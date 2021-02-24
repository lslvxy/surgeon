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
package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.convertor.DictDetailDTOConvertor;
import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.domain.gateway.DictDetailGateway;
import com.github.surgeon.dto.data.DictDetailDTO;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictDetailFindByIdQryExe {

    @Resource
    private DictDetailGateway dictDetailGateway;
    @Autowired
    private DictDetailDTOConvertor dictDetailDTOConvertor;

    public SingleResponse<DictDetailDTO> execute(IdQuery query) {
        DictDetail byId = dictDetailGateway.findById(query.getId());
        DictDetailDTO dto = dictDetailDTOConvertor.toSource(byId);
        return SingleResponse.of(dto);
    }
}
