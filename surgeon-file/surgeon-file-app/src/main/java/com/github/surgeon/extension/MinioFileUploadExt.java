package com.github.surgeon.extension;

import cn.hutool.core.lang.Assert;
import com.alibaba.cola.extension.Extension;
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
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import com.github.surgeon.config.MinioProp;

@Extension(bizId = FileProviderConstants.MINIO)
@Component
public class MinioFileUploadExt implements FileUploadExtPt {
    @Resource
    private MinioClient minioClient;
    @Resource
    private MinioProp   minioProp;

    @Override
    public FileUploadDTO upload(FileUploadCmd cmd) {
        String finalFileName = FileUtils.getPathByTime(cmd.getFileName());
        try {
            InputStream inputStream = cmd.getInputStream();
            minioClient.putObject(minioProp.getBucket(), finalFileName, inputStream,
                    new PutObjectOptions(inputStream.available(), -1));
            ObjectStat objectStat = minioClient.statObject(minioProp.getBucket(), finalFileName);
            Assert.notNull(objectStat, "上传失败");
            FileUploadDTO dto = new FileUploadDTO();
            dto.setFilePath(finalFileName);
            dto.setFileName(cmd.getFileName());
            return dto;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public FileDownloadDTO download(FileDownloadCmd cmd) {
        return null;
    }

    @Override
    public void delete(FileDeleteCmd cmd) {

    }
}