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
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.surgeon.constant.SurgeonConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author lise
 */
@Getter
@Setter
@Accessors(chain = true)
public class FileDTO extends DTO {
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = SurgeonConstants.DATE_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @ApiModelProperty(value = "是否删除  1：已删除  0：正常")
    private Integer deleted;

    @ApiModelProperty(value = "文件MD5")
    private String md5;

    @ApiModelProperty(value = "文件名称")
    @NotEmpty
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    @NotEmpty
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    private Long fileSize;

    @ApiModelProperty(value = "文件类型")
    private String contentType;
}
