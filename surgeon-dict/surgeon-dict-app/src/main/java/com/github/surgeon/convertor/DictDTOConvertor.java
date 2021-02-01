package com.github.surgeon.convertor;

import com.github.surgeon.base.BaseConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.dto.data.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDTOConvertor extends BaseConvertor<DictDTO, Dict> {
}
