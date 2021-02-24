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
package com.github.surgeon.dataobject;

import com.github.surgeon.base.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

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