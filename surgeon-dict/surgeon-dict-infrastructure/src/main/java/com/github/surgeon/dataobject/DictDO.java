package com.github.surgeon.dataobject;

import com.github.surgeon.base.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class DictDO extends BaseDO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "ID")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "字典名称")
    private String name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @ApiModelProperty(value = "描述")
    private String description;
}