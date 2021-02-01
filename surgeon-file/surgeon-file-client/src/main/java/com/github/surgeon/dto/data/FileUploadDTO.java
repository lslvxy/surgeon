package com.github.surgeon.dto.data;

import com.alibaba.cola.dto.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.surgeon.constant.KamalaConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lise
 */
@Getter
@Setter
@Accessors(chain = true)
public class FileUploadDTO extends DTO {
    @ApiModelProperty(value = "ID", hidden = true)
    private Long id;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = KamalaConstants.DATE_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @ApiModelProperty(value = "文件URL")
    private String fileUrl;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

}
