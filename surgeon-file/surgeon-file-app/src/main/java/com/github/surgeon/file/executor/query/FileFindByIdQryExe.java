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
package com.github.surgeon.file.executor.query;

import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.file.File;
import com.github.surgeon.file.convertor.FileDTOConvertor;
import com.github.surgeon.file.dto.data.FileDTO;
import com.github.surgeon.file.gateway.FileGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class FileFindByIdQryExe {

    @Resource
    private FileGateway      fileGateway;
    @Autowired
    private FileDTOConvertor fileDTOConvertor;

    public SingleResponse<FileDTO> execute(IdQuery query) {
        File byId = fileGateway.findById(query.getId());
        FileDTO dto = fileDTOConvertor.toSource(byId);
        return SingleResponse.of(dto);
    }
}
