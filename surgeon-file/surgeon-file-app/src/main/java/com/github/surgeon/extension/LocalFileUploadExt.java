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
package com.github.surgeon.extension;

import com.alibaba.cola.extension.Extension;
import com.github.surgeon.config.LocalProp;
import com.github.surgeon.constant.FileProviderConstants;
import com.github.surgeon.dto.FileDeleteCmd;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.extensionpoint.FileUploadExtPt;
import com.github.surgeon.util.FileUtils;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedInputStream;
import java.io.File;

@Extension(bizId = FileProviderConstants.LOCAL)
public class LocalFileUploadExt implements FileUploadExtPt {
    @Autowired
    private LocalProp localProp;

    @Override
    public FileUploadDTO upload(FileUploadCmd cmd) {
        String rootPath = localProp.getPath();
        String finalFileName = FileUtils.getPathByTime(cmd.getFileName());
        String fullPath = Joiner.on(File.separator).join(rootPath, finalFileName);

        FileUtils.writeFromStream(cmd.getInputStream(), fullPath);
        FileUploadDTO dto = new FileUploadDTO();
        dto.setFilePath(finalFileName);
        dto.setFileName(cmd.getFileDTO().getFileName());
        return dto;
    }

    @Override
    public FileDownloadDTO download(FileDownloadCmd cmd) {
        String rootPath = localProp.getPath();
        String fullPath = Joiner.on(File.separator).join(rootPath, cmd.getFilePath());
        BufferedInputStream inputStream = FileUtils.getInputStream(fullPath);
        FileDownloadDTO dto = new FileDownloadDTO();
        dto.setFileName("");
        dto.setFileInputStream(inputStream);
        return dto;
    }

    @Override
    public void delete(FileDeleteCmd cmd) {

    }
}
