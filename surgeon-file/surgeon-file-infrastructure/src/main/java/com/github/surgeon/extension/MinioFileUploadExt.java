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
package com.github.surgeon.extension;

import cn.hutool.core.lang.Assert;
import com.alibaba.cola.extension.Extension;
import com.github.surgeon.config.MinioProp;
import com.github.surgeon.constant.FileProviderConstants;
import com.github.surgeon.dto.FileDeleteCmd;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.extensionpoint.FileUploadExtPt;
import com.github.surgeon.util.FileUtils;
import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Objects;

@Extension(bizId = FileProviderConstants.MINIO)
@Component
public class MinioFileUploadExt implements FileUploadExtPt {
    @Autowired(required = false)
    private MinioClient minioClient;
    @Resource
    private MinioProp minioProp;

    @Override
    public FileUploadDTO upload(FileUploadCmd cmd) {
        Objects.requireNonNull(cmd.getFileDTO());
        Objects.requireNonNull(cmd.getInputStream());
        String finalFileName = FileUtils.getPathByTime(cmd.getFileDTO().getFileName());
        try {
            InputStream inputStream = cmd.getInputStream();
            Assert.notNull(minioClient, "minioClient 配置错误");
            minioClient.putObject(minioProp.getBucket(), finalFileName, inputStream,
                    new PutObjectOptions(inputStream.available(), -1));
            ObjectStat objectStat = minioClient.statObject(minioProp.getBucket(), finalFileName);
            Assert.notNull(objectStat, "上传失败");
            FileUploadDTO dto = new FileUploadDTO();
            dto.setFilePath(finalFileName);
            dto.setFileName(cmd.getFileDTO().getFileName());
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileDownloadDTO download(FileDownloadCmd cmd) {
        try {
            Assert.notNull(minioClient, "minioClient 配置错误");
            InputStream inputStream = minioClient.getObject(minioProp.getBucket(), cmd.getFilePath());
            FileDownloadDTO dto = new FileDownloadDTO();
            dto.setFileInputStream(inputStream);
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(FileDeleteCmd cmd) {

    }
}
