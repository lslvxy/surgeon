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

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.dict.DictDetail;
import com.github.surgeon.dict.convertor.DictDetailDTOConvertor;
import com.github.surgeon.dict.dto.DictDetailQuery;
import com.github.surgeon.dict.dto.data.DictDetailDTO;
import com.github.surgeon.dict.gateway.DictDetailGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DictDetailListQryExe {

    @Resource
    private DictDetailGateway dictDetailGateway;
    @Resource
    private DictDetailDTOConvertor dictDetailDTOConvertor;

    public MultiResponse<DictDetailDTO> execute(DictDetailQuery qry) {
        List<DictDetail> all = dictDetailGateway.findAll(qry);
        return MultiResponse.of(dictDetailDTOConvertor.toSource(all));
    }
}
