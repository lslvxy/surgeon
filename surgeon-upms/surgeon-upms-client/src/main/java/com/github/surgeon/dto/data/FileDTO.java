package com.github.surgeon.dto.data;

import com.alibaba.cola.dto.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.surgeon.constant.KamalaConstants;
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
    @JsonFormat(pattern = KamalaConstants.DATE_YYYY_MM_DD_HH_MM_SS)
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
