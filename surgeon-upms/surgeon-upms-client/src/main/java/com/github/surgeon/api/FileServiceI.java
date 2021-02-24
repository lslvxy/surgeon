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
package com.github.surgeon.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dto.FileDeleteCmd;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileServiceI {
    /**
     * 下载文件
     *
     * @throws IOException /
     */
    SingleResponse<FileDownloadDTO> download(Long id);

    SingleResponse<FileUploadDTO> upload(MultipartFile file);

    /**
     * 根据ID查询
     *
     * @param query
     * @return /
     */
    SingleResponse<FileDTO> findById(IdQuery query);

    /**
     * 根据文件名查询
     *
     * @param nameQuery
     * @return
     */
    MultiResponse<FileDTO> listByName(NameQuery nameQuery);

    /**
     * 分页查询
     *
     * @return /
     */
    MultiResponse<FileDTO> findAll();

    /**
     * 删除
     *
     * @param cmd /
     */
    Response delete(FileDeleteCmd cmd);

}
