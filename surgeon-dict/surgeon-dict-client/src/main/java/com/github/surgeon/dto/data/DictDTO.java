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
package com.github.surgeon.dto.data;

import com.alibaba.cola.dto.DTO;
import com.github.surgeon.annotation.Unique;
import com.github.surgeon.annotation.UniqueColumn;
import com.github.surgeon.api.DictServiceI;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * @author lise
 */
@Getter
@Setter
@Accessors(chain = true)
@Unique(service = DictServiceI.class,
        message = "字典[{}]已存在",
        columns = {
                @UniqueColumn(fields = "code"),
        })
public class DictDTO extends DTO {
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @ApiModelProperty(value = "字典名称")
    @NotBlank(message = "字典名称不能为空")
    private String name;

    @ApiModelProperty(value = "字典Code")
    private String code;

    @ApiModelProperty(value = "描述")
    private String description;


}
