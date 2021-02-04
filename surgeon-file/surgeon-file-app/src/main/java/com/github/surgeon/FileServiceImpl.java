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
package com.github.surgeon;

import cn.hutool.core.util.StrUtil;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.SysException;
import com.alibaba.cola.extension.BizScenario;
import com.github.surgeon.api.FileServiceI;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.executor.FileDeleteCmdExe;
import com.github.surgeon.executor.FileDownloadCmdExe;
import com.github.surgeon.executor.FileUploadCmdExe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service
@CatchAndLog
public class FileServiceImpl implements FileServiceI {

    @Value("${surgeon.file.provider:local}")
    private String provider;

    private BizScenario scenario;

    @Resource
    private FileUploadCmdExe fileUploadCmdExe;
    @Resource
    private FileDownloadCmdExe fileDownloadCmdExe;

    @Resource
    private FileDeleteCmdExe fileDeleteCmdExe;


    @PostConstruct
    private void initialize() {
        scenario = BizScenario.valueOf(provider);
    }

    @Override
    public SingleResponse<FileDownloadDTO> download(FileDownloadCmd cmd) {
        cmd.setBizScenario(scenario);
        if (StrUtil.isBlank(cmd.getFilePath())) {
            return SingleResponse.buildFailure("500", "下载失败，请选择文件");
        }
        return fileDownloadCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<FileUploadDTO> upload(FileUploadCmd cmd) {
        try {
            cmd.setBizScenario(scenario);

            if (cmd.getSize().compareTo(0L) <= 0) {
                return SingleResponse.buildFailure("500", "上传失败，请选择文件");
            }

            FileUploadDTO uploadResult = fileUploadCmdExe.execute(cmd);


            uploadResult.setFileUrl("/file/download/" + uploadResult.getFilePath());

            return SingleResponse.of(uploadResult);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("上传失败");
        }
    }

}