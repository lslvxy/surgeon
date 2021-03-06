/*
 * Copyright © 2021 Laysan (lslvxy@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.surgeon.dict.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dict.Dict;
import com.github.surgeon.dict.convertor.DictDTOConvertor;
import com.github.surgeon.dict.dto.data.DictDTO;
import com.github.surgeon.dict.gateway.DictGateway;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictFindByIdQryExe {

    @Resource
    private DictGateway dictGateway;
    @Autowired
    private DictDTOConvertor dictDTOConvertor;

    public SingleResponse<DictDTO> execute(IdQuery query) {
        Dict byId = dictGateway.findById(query.getId());
        DictDTO dto = dictDTOConvertor.toSource(byId);
        return SingleResponse.of(dto);
    }
}
