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
package com.github.surgeon.executor;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.github.surgeon.constant.Constants;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.extensionpoint.FileUploadExtPt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class FileUploadCmdExe {

    @Resource
    private ExtensionExecutor extensionExecutor;

    public FileUploadDTO execute(FileUploadCmd cmd) {

        if (Objects.isNull(cmd.getBizScenario())) {
            BizScenario scenario = BizScenario.valueOf(Constants.LOCAL);
            cmd.setBizScenario(scenario);
        }
        return extensionExecutor.execute(FileUploadExtPt.class, cmd.getBizScenario(), v -> v.upload(cmd));
    }

}
