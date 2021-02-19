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
package com.github.surgeon.executor;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.convertor.DictDetailDTOConvertor;
import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.domain.gateway.DictDetailGateway;
import com.github.surgeon.dto.DictDetailSaveCmd;
import com.github.surgeon.dto.data.DictDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictDetailSaveExe {

    @Resource
    private DictDetailGateway dictGateway;
    @Autowired
    private DictDetailDTOConvertor dictDTOConvertor;

    public SingleResponse<DictDetailDTO> execute(DictDetailSaveCmd cmd) {
        DictDetailDTO dictDetailDTO = cmd.getDictDetail();
        DictDetail dictDetail = dictGateway.create(dictDTOConvertor.toTarget(dictDetailDTO));
        return SingleResponse.of(dictDTOConvertor.toSource(dictDetail));
    }

}
