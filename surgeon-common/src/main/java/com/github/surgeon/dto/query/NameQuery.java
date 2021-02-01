package com.github.surgeon.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class NameQuery extends Query {
    private String name;
}