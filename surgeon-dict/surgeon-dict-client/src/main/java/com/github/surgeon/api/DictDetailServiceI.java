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
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dto.DictDetailPageQuery;
import com.github.surgeon.dto.DictDetailQuery;
import com.github.surgeon.dto.DictDetailSaveCmd;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDetailDTO;
import com.github.surgeon.dto.query.IdQuery;

public interface DictDetailServiceI {

    /**
     * 根据ID查询
     *
     * @param query
     * @return /
     */
    SingleResponse<DictDetailDTO> findById(IdQuery query);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResponse<DictDetailDTO> findPage(DictDetailPageQuery query);

    /**
     * 根据名查询
     *
     * @param query
     * @return
     */
    MultiResponse<DictDetailDTO> findAll(DictDetailQuery query);

    /**
     * 分页查询
     *
     * @return /
     */
    MultiResponse<DictDetailDTO> findAll();

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
    SingleResponse<DictDetailDTO> create(DictDetailSaveCmd cmd);

    /**
     * 删除
     *
     * @param cmd
     * @return
     */
    SingleResponse<DictDetailDTO> update(DictDetailSaveCmd cmd);

}
