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
    private DictGateway dictGateway;
    @Autowired
    private DictDTOConvertor dictDTOConvertor;

    public SingleResponse<DictDTO> execute(DictSaveCmd cmd) {
        Dict dict = dictDTOConvertor.toTarget(cmd.getDict());
        if (Objects.isNull(cmd.getDict().getId())) {
            dict = dictGateway.create(dict);
        } else {
            dict = dictGateway.update(dict);
        }
        DictDTO dictDTO = dictDTOConvertor.toSource(dict);
        return SingleResponse.of(dictDTO);
    }

}
