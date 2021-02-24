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
package com.github.surgeon.executor.query;

import com.alibaba.cola.dto.MultiResponse;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileListByNameQryExe {

    public MultiResponse<FileDTO> execute(NameQuery query) {
        List<FileDTO> fileDTOList = new ArrayList<>();
        FileDTO fileDTO = new FileDTO();
        fileDTOList.add(fileDTO);
        return MultiResponse.of(fileDTOList);
    }
}
