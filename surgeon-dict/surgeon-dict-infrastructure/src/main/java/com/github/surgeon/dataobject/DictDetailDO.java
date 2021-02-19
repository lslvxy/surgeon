/*
 * Copyright © ${project.inceptionYear} Laysan (lslvxy@gmail.com)
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
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DictDetailDO extends BaseDO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "ID")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "字典id")
    private Long dictId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "字典标签")
    private String text;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "字典值")
    private String value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "排序")
    private Integer dictSort;
}