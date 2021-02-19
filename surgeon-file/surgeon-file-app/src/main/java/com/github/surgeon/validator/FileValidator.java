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
package com.github.surgeon.validator;

import cn.hutool.core.lang.Assert;
import com.github.surgeon.dto.FileUploadCmd;

public class FileValidator {

    public static void checkFileUpload(FileUploadCmd cmd) {
        Assert.notNull(cmd.getInputStream(), "文件不能为空");
        Assert.notNull(cmd.getFileDTO(), "文件不能为空");
        Assert.notBlank(cmd.getFileDTO().getFileName(), "文件名不能为空");
    }
}
