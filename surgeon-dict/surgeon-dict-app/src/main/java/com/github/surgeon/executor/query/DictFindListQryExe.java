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
import com.github.surgeon.convertor.DictDTOConvertor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.DictQuery;
import com.github.surgeon.dto.data.DictDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DictFindListQryExe {

    @Resource
    private DictGateway dictGateway;
    @Resource
    private DictDTOConvertor dictDTOConvertor;

    public MultiResponse<DictDTO> execute(DictQuery qry) {
        List<Dict> all = dictGateway.findAll(qry.getName());
        return MultiResponse.of(dictDTOConvertor.toSource(all));
    }
}
