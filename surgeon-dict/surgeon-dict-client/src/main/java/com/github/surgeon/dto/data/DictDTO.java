package com.github.surgeon.dto.data;

import com.alibaba.cola.dto.DTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author lise
 */
@Getter
@Setter
@Accessors(chain = true)
public class DictDTO extends DTO {
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @ApiModelProperty(value = "字典名称")
    private String name;

    @ApiModelProperty(value = "描述")
    private String description;
}
