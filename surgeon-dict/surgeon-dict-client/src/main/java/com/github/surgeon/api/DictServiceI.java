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
package com.github.surgeon.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.dto.query.NameQuery;

public interface DictServiceI {

    /**
     * 根据ID查询
     *
     * @param query
     * @return /
     */
    SingleResponse<DictDTO> findById(IdQuery query);

    /**
     * 根据文件名查询
     *
     * @param nameQuery
     * @return
     */
    MultiResponse<DictDTO> listByName(NameQuery nameQuery);

    /**
     * 分页查询
     *
     * @return /
     */
    MultiResponse<DictDTO> findAll();

    /**
     * 删除
     *
     * @param cmd /
     */
    Response delete(DeleteByIdCmd cmd);

    /**
     * 创建
     *
     * @param cmd
     * @return
     */
    SingleResponse<DictDTO> create(DictSaveCmd cmd);

    /**
     * 删除
     *
     * @param cmd
     * @return
     */
    SingleResponse<DictDTO> update(DictSaveCmd cmd);

}
