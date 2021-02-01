package com.github.surgeon.convertor;

import com.github.surgeon.base.BaseConvertor;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.dataobject.FileDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  FileDOConvertor extends BaseConvertor<FileDO, File> {
}
