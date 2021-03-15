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
package com.github.surgeon.file.extensionpoint;

import com.alibaba.cola.extension.ExtensionPointI;
import com.github.surgeon.file.dto.FileDeleteCmd;
import com.github.surgeon.file.dto.FileDownloadCmd;
import com.github.surgeon.file.dto.FileUploadCmd;
import com.github.surgeon.file.dto.data.FileDownloadDTO;
import com.github.surgeon.file.dto.data.FileUploadDTO;

public interface FileUploadExtPt extends ExtensionPointI {

    FileUploadDTO upload(FileUploadCmd cmd);

    FileDownloadDTO download(FileDownloadCmd cmd);

    void delete(FileDeleteCmd cmd);
}