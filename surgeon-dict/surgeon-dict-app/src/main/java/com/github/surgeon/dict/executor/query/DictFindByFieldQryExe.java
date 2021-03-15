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

import com.github.surgeon.dict.Dict;
import com.github.surgeon.dict.gateway.DictGateway;
import com.github.surgeon.dto.query.FindByFieldQuery;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictFindByFieldQryExe {

    @Resource
    private DictGateway dictGateway;

    public Dict execute(FindByFieldQuery query) {
        return dictGateway.findByField(query.getFieldMap());
    }
}
