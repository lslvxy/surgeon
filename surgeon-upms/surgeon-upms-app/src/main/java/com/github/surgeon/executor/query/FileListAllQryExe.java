package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.convertor.FileDTOConvertor;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.dto.data.FileDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FileListAllQryExe {

    @Resource
    private FileGateway      fileGateway;
    @Resource
    private FileDTOConvertor fileDTOConvertor;

    public MultiResponse<FileDTO> execute() {
        List<File> all = fileGateway.findAll();
        return MultiResponse.of(fileDTOConvertor.toDto(all));
    }
}
