package com.github.surgeon.dto.data;

import com.alibaba.cola.dto.DTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.InputStream;

/**
 * @author lise
 */
@Getter
@Setter
@Accessors(chain = true)
public class FileDownloadDTO extends DTO {

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件流", hidden = true)
    private InputStream fileInputStream;

}
