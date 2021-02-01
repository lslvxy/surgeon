package com.github.surgeon.convertor;

import com.github.surgeon.base.BaseConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.data.DictDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {DictDTOConvertor.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictDetailDTOConvertor extends BaseConvertor<DictDetailDTO, DictDetail> {
}
