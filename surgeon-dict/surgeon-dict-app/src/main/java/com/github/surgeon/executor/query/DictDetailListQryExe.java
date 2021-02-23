/*
 * Copyright © ${project.inceptionYear} Laysan (lslvxy@gmail.com)
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

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.convertor.DictDetailDTOConvertor;
import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.domain.gateway.DictDetailGateway;
import com.github.surgeon.dto.DictDetailQuery;
import com.github.surgeon.dto.data.DictDetailDTO;
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