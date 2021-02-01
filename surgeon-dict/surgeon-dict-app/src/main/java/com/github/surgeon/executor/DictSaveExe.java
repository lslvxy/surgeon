
package com.github.surgeon.executor;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.convertor.DictDTOConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.data.DictDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class DictSaveExe {

    @Resource
    private DictGateway      dictGateway;
    @Autowired
    private DictDTOConvertor dictDTOConvertor;

    public SingleResponse<DictDTO> execute(DictSaveCmd cmd) {
        Dict dict = dictDTOConvertor.toEntity(cmd.getDictDTO());
        if (Objects.isNull(cmd.getDictDTO().getId())) {
            dict = dictGateway.create(dict);
        } else {
            dict = dictGateway.update(dict);
        }
        DictDTO dictDTO = dictDTOConvertor.toDto(dict);
        return SingleResponse.of(dictDTO);
    }

}
