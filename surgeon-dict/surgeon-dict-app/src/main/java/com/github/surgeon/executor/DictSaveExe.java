
package com.github.surgeon.executor;

import com.github.surgeon.convertor.DictDTOConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.data.DictDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictSaveExe {

    @Resource
    private DictGateway      dictGateway;
    @Autowired
    private DictDTOConvertor dictDTOConvertor;

    public DictDTO execute(DictSaveCmd cmd) {
        Dict dict = dictDTOConvertor.toEntity(cmd.getDictDTO());
        return dictDTOConvertor.toDto(dictGateway.create(dict));
    }

}
