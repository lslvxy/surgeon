/*
 * Copyright © 2021 Laysan (lslvxy@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.surgeon.config;

import com.github.surgeon.config.CacheNameProperties.CacheSpec;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.DurationStyle;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/**
 * Swagger2配置
 *
 * @author Laysan
 */
@Slf4j
@Data
@EnableCaching
@Configuration
@EnableConfigurationProperties(value = {CacheProperties.class, CacheNameProperties.class})
@ConditionalOnMissingBean(CacheManager.class)
@ConditionalOnClass({RedisCache.class, RedisCacheManager.class})
@ConditionalOnProperty(value = "spring.cache.type", havingValue = "redis", matchIfMissing = true)
public class RedisCacheAutoConfiguration {

    @Bean
    public CacheManager cacheManager(CacheNameProperties cacheNameProperties,
                                     RedisConnectionFactory lettuceConnectionFactory) {
        Map<String, CacheSpec> specs = cacheNameProperties.getSpecs();
        if (Objects.isNull(specs)) {
            specs = new HashMap<>(1);
            specs.put("defaultCache", new CacheSpec(cacheNameProperties.getDefaultTimeout()));
        }

        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        // 设置缓存管理器管理的缓存的默认过期时间
        defaultCacheConfig = defaultCacheConfig.entryTtl(
                DurationStyle.detectAndParse(cacheNameProperties.getDefaultTimeout(), ChronoUnit.SECONDS))
                // 设置 key为string序列化
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                // 设置value为json序列化
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
                // 不缓存空值
                .disableCachingNullValues();

        Set<String> cacheNames = specs.keySet();
        // 对每个缓存空间应用不同的配置

        Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
        for (Entry<String, CacheSpec> v : specs.entrySet()) {
            configMap.put(v.getKey(),
                    defaultCacheConfig.entryTtl(DurationStyle.detectAndParse(v.getValue().getTimeout(), ChronoUnit.SECONDS)));
        }

        return RedisCacheManager.builder(lettuceConnectionFactory)
                .cacheDefaults(defaultCacheConfig)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(configMap)
                .build();
    }

}
