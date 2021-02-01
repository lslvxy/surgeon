package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.convertor.DictDTOConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.data.DictDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DictListAllQryExe {

    @Resource
    private DictGateway      dictGateway;
    @Resource
    private DictDTOConvertor dictDTOConvertor;

    public MultiResponse<DictDTO> execute() {
        List<Dict> all = dictGateway.findAll();
        return MultiResponse.of(dictDTOConvertor.toDto(all));
    }
}
