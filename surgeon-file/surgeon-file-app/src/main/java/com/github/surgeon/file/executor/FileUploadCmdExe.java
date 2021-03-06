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
package com.github.surgeon.file.executor;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.github.surgeon.file.File;
import com.github.surgeon.file.constant.FileProviderConstants;
import com.github.surgeon.file.convertor.FileDTOConvertor;
import com.github.surgeon.file.dto.FileUploadCmd;
import com.github.surgeon.file.dto.data.FileUploadDTO;
import com.github.surgeon.file.extensionpoint.FileUploadExtPt;
import com.github.surgeon.file.gateway.FileGateway;
import com.github.surgeon.file.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class FileUploadCmdExe {

    @Resource
    private ExtensionExecutor extensionExecutor;
    @Resource
    private FileGateway fileGateway;
    @Autowired
    private FileDTOConvertor fileDTOConvertor;

    public SingleResponse<FileUploadDTO> execute(FileUploadCmd cmd) {
        FileValidator.checkFileUpload(cmd);

        if (Objects.isNull(cmd.getBizScenario())) {
            BizScenario scenario = BizScenario.valueOf(FileProviderConstants.LOCAL);
            cmd.setBizScenario(scenario);
        }

        FileUploadDTO execute = extensionExecutor.execute(FileUploadExtPt.class, cmd.getBizScenario(), v -> v.upload(cmd));

        File file = fileDTOConvertor.toTarget(cmd.getFileDTO());
        file.setFilePath(execute.getFilePath());
        file = fileGateway.create(file);
        execute.setId(file.getId());
        execute.setFileUrl("/file/download/" + file.getId());
        return SingleResponse.of(execute);
    }

}
