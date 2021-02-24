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
package com.github.surgeon.domain;

import com.github.surgeon.base.BaseDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@Accessors(chain = true)

public class Dict extends BaseDomain {
    @ApiModelProperty(value = "ID")
    private Long id;

    @NotBlank(message = "字典名称不能为空")
    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "字典Code")
    private String code;

    @ApiModelProperty(value = "描述")
    private String description;

    public static void main(String[] args) {
        String s = "create.arg0.name: 字典名称不能为空, create.arg0.code: Must be after";
        System.out.println(s.replaceAll("\\S*: ", ""));
    }
}
