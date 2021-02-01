
package com.github.surgeon.executor;

import com.github.surgeon.convertor.FileDTOConvertor;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.dto.FileSaveCmd;
import com.github.surgeon.dto.data.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FileSaveExe {

    @Resource
    private FileGateway      fileGateway;
    @Autowired
    private FileDTOConvertor fileDTOConvertor;

    public FileDTO execute(FileSaveCmd cmd) {
        File file = fileDTOConvertor.toEntity(cmd.getFileDTO());
        return fileDTOConvertor.toDto(fileGateway.create(file));
    }

}
