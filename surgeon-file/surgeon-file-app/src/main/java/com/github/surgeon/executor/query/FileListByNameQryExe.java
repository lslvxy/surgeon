package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileListByNameQryExe {

    public MultiResponse<FileDTO> execute(NameQuery query) {
        List<FileDTO> fileDTOList = new ArrayList<>();
        FileDTO fileDTO = new FileDTO();
        fileDTOList.add(fileDTO);
        return MultiResponse.of(fileDTOList);
    }
}
