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
package com.github.surgeon.file.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.file.dto.FileDeleteCmd;
import com.github.surgeon.file.dto.FileDownloadCmd;
import com.github.surgeon.file.dto.FilePageQuery;
import com.github.surgeon.file.dto.FileQuery;
import com.github.surgeon.file.dto.FileUploadCmd;
import com.github.surgeon.file.dto.data.FileDTO;
import com.github.surgeon.file.dto.data.FileDownloadDTO;
import com.github.surgeon.file.dto.data.FileUploadDTO;

import java.io.IOException;

public interface FileServiceI {
    /**
     * 下载文件
     *
     * @throws IOException /
     */
    SingleResponse<FileDownloadDTO> download(FileDownloadCmd cmd);

    SingleResponse<FileUploadDTO> upload(FileUploadCmd cmd);

    /**
     * 分页查询
     *
     * @return /
     */

    MultiResponse<FileDTO> findAll(FileQuery query);

    PageResponse<FileDTO> findPage(FilePageQuery query);


    SingleResponse<FileDTO> findById(IdQuery query);

    /**
     * 删除
     *
     * @param cmd /
     */
    Response delete(FileDeleteCmd cmd);

}
