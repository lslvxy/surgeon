package com.github.surgeon.extensionpoint;

import com.alibaba.cola.extension.ExtensionPointI;
import com.github.surgeon.dto.FileDeleteCmd;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;

public interface FileUploadExtPt extends ExtensionPointI {

    FileUploadDTO upload(FileUploadCmd cmd);

    FileDownloadDTO download(FileDownloadCmd cmd);

    void delete(FileDeleteCmd cmd);
}
