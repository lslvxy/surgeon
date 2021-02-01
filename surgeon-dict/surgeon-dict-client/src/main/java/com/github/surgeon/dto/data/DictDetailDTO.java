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
public class DictDetailDTO extends DTO {
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    private DictDTO dict;

    private Integer dictSort;

    private String label;

    private String value;

}
