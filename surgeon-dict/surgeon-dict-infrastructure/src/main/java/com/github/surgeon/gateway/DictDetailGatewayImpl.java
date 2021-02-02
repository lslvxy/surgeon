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
package com.github.surgeon.gateway;

import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictDetailGateway;

import java.util.List;

public class DictDetailGatewayImpl implements DictDetailGateway {
    @Override
    public Dict findById(Long id) {
        return null;
    }

    @Override
    public List<Dict> listByName(String fileName) {
        return null;
    }

    @Override
    public List<Dict> findAll() {
        return null;
    }

    @Override
    public Dict create(Dict dict) {
        return null;
    }

    @Override
    public Dict update(Dict dict) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
