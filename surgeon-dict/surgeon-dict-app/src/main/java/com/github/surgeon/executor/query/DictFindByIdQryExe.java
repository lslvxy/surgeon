package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.convertor.DictDTOConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictFindByIdQryExe {

    @Resource
    private DictGateway      dictGateway;
    @Autowired
    private DictDTOConvertor dictDTOConvertor;

    public SingleResponse<DictDTO> execute(IdQuery query) {
        Dict byId = dictGateway.findById(query.getId());
        DictDTO dto = dictDTOConvertor.toDto(byId);
        return SingleResponse.of(dto);
    }
}
