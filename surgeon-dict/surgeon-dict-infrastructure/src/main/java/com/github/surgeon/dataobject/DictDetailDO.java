package com.github.surgeon.dataobject;

import com.github.surgeon.base.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import javax.annotation.Generated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DictDetailDO extends BaseDO {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer dictSort;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String label;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String value;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long dictId;
}