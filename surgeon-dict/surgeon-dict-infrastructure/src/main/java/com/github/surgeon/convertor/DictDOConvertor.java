package com.github.surgeon.convertor;

import com.github.surgeon.base.BaseConvertor;
import com.github.surgeon.dataobject.DictDO;
import com.github.surgeon.domain.Dict;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDOConvertor extends BaseConvertor<DictDO, Dict> {
}
