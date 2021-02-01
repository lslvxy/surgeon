package com.github.surgeon.domain;

import com.github.surgeon.base.BaseDomain;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors(chain = true)
public class Dict extends BaseDomain {
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;
}
