package com.github.surgeon.convertor;

import com.github.surgeon.base.BaseConvertor;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.dto.data.FileDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FileDTOConvertor extends BaseConvertor<FileDTO, File> {
}
