package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileListByNameQryExe {

    public MultiResponse<DictDTO> execute(NameQuery query) {
        List<DictDTO> dictDTOList = new ArrayList<>();
        DictDTO dictDTO = new DictDTO();
        dictDTOList.add(dictDTO);
        return MultiResponse.of(dictDTOList);
    }
}
