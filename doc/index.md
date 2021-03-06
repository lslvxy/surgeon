# Surgeon 研发手册

## Swagger 文档

`application.yml` 中配置

注意: 添加有 `@Api` 注解的控制器才会自动暴露给 swagger。

```yaml
surgeon:
  swagger:
    enable: true
    title: 测试
    description: xxx项目
    version: V1.0
```

自定义配置

```java
@Bean
public SwaggerCustomizer swaggerCustomizer(){
        return(docket)->{
        docket.xxxx
        };
        }

```

## Domain 唯一性校验

需要校验的DTO加上注解

```
@Unique(
        service = DictServiceI.class,  # 需要调用的Service
        message = "字典[${value}]已存在", # 验证失败消息,变量支持 ${name},${fullName},${field},${allFields},${value},${values},
        columns = {
                @UniqueColumn(fields = {"code"}), # 唯一的列
        })
```

## 缓存

集成Spring-Cache实现缓存功能

支持 `caffeine` 本地缓存以及`redis`缓存

### cacheName 配置

`application.yml` 中配置

```yml
surgeon:
  caching:
    default-timeout: 60s  # 默认超时时间
    specs:
      dictCache: #cache名称
        timeout: 20       #超时时间
        max: 500          #缓存大小
      userCache:
        timeout: 60
        max: 500
      testCache:
        timeout: 5
        max: 10
```

ServiceImpl中使用的cacheNames 必须先在 yml中配置

`@CacheConfig(cacheNames = "dictCache")`

### 全局禁用缓存

`application.yml` 中配置

```yml
spring
cache:
  type: none
```

### caffeine 配置

`application.yml` 中配置

```yml
spring
cache:
  type: caffeine
```

### redis 配置

`application.yml` 中配置

```yml
spring
cache:
  type: redis
```

## 文件上传

支持服务器本地存储以及[minio](http://www.minio.org.cn/)

```yml
surgeon:
  file:
    provider: local  # 文件服务 local or minio
    local:
      linux:
        path: /home/lise/file/
      mac:
        path: /Users/lise/file/
      windows:
        path: C:\file\
    minio:
      endpoint: http://laysan.com:9000
      accessKey: minio
      secretKey: minio@123
      bucket: ${spring.application.name} # 桶名称
```

### TODO

* fastdfs

* oss

* ftp

### IP 转地址

`surgeon-ip2region` 是 `ip2region` 的封装，方便 `spring boot` 用户使用。

## 配置说明（已经内置，可忽略）

| 配置项                           | 默认值                            | 说明                                |
| ------------------------------- | -------------------------------- | ---------------------------------- |
| surgeon.ip2region.db-file-location | classpath:ip2region/ip2region.db | ip2region.db 文件的地址，默认内置的文件 | 

**maven** `resources` 拷贝文件是默认会做 `filter`，会导致我们的文件发生变化，导致不能读，`pom` 中你需要添加下面的配置。

```xml

<plugin>
    <artifactId>maven-resources-plugin</artifactId>
    <configuration>
        <nonFilteredFileExtensions>
            <nonFilteredFileExtension>db</nonFilteredFileExtension>
        </nonFilteredFileExtensions>
    </configuration>
</plugin>
```

### 注入 bean

```java
@Autowired
private Ip2regionSearcher regionSearcher;
```

### 方法说明

```java
/**
 * ip 位置 搜索
 *
 * @param ip ip
 * @return 位置
 */
@Nullable
IpInfo memorySearch(long ip);

/**
 * ip 位置 搜索
 *
 * @param ip ip
 * @return 位置
 */
@Nullable
IpInfo memorySearch(String ip);

/**
 * ip 位置 搜索
 *
 * @param ptr ptr
 * @return 位置
 */
@Nullable
IpInfo getByIndexPtr(long ptr);

/**
 * ip 位置 搜索
 *
 * @param ip ip
 * @return 位置
 */
@Nullable
IpInfo btreeSearch(long ip);

/**
 * ip 位置 搜索
 *
 * @param ip ip
 * @return 位置
 */
@Nullable
IpInfo btreeSearch(String ip);

/**
 * ip 位置 搜索
 *
 * @param ip ip
 * @return 位置
 */
@Nullable
IpInfo binarySearch(long ip);

/**
 * ip 位置 搜索
 *
 * @param ip ip
 * @return 位置
 */
@Nullable
IpInfo binarySearch(String ip);
```

