package com.github.surgeon.dataobject;

import com.github.surgeon.base.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Generated;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FileDO extends BaseDO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "是否删除  1：已删除  0：正常")
    private Integer deleted;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "文件MD5")
    private String md5;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "文件大小")
    private Long fileSize;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "文件类型")
    private String contentType;
}