package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.convertor.FileDTOConvertor;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FileFindByIdQryExe {

    @Resource
    private FileGateway      fileGateway;
    @Autowired
    private FileDTOConvertor fileDTOConvertor;

    public SingleResponse<FileDTO> execute(IdQuery query) {
        File byId = fileGateway.findById(query.getId());
        FileDTO dto = fileDTOConvertor.toDto(byId);
        return SingleResponse.of(dto);
    }
}
