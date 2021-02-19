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
package com.github.surgeon.domain.gateway;

import com.github.surgeon.domain.DictDetail;
import com.github.surgeon.dto.DictDetailQuery;

import java.util.List;

public interface DictDetailGateway {
    /**
     * 根据ID查询
     *
     * @param id
     * @return /
     */
    DictDetail findById(Long id);

    /**
     * 根据条件查询
     *
     * @param qry
     * @return
     */
    List<DictDetail> findAll(DictDetailQuery qry);

    /**
     * 分页查询
     *
     * @return /
     */
    List<DictDetail> findAll();

    /**
     * 创建
     *
     * @param dictDetail
     */
    DictDetail create(DictDetail dictDetail);

    /**
     * update
     *
     * @param dictDetail
     */
    DictDetail update(DictDetail dictDetail);

    /**
     * 删除
     *
     * @param id /
     */
    boolean delete(Long id);
}
