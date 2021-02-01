package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.convertor.FileDTOConvertor;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FileListByNameQryExe {
    @Resource
    private FileGateway      fileGateway;
    @Resource
    private FileDTOConvertor fileDTOConvertor;

    public MultiResponse<FileDTO> execute(NameQuery query) {
        List<File> files = fileGateway.listByName(query.getName());
        return MultiResponse.of(fileDTOConvertor.toDto(files));
    }
}
