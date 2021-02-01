package com.github.surgeon.domain;

import com.github.surgeon.base.BaseDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class DictDetail extends BaseDomain {
    private Long id;

    private Dict dict;

    private Integer dictSort;

    private String label;

    private String value;

}