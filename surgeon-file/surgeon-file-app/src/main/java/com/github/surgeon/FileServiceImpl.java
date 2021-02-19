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

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.extension.BizScenario;
import com.github.surgeon.api.FileServiceI;
import com.github.surgeon.dto.*;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.executor.FileDeleteCmdExe;
import com.github.surgeon.executor.FileDownloadCmdExe;
import com.github.surgeon.executor.FileUploadCmdExe;
import com.github.surgeon.executor.query.FileFindByIdQryExe;
import com.github.surgeon.executor.query.FileFindPageQryExe;
import com.github.surgeon.executor.query.FileListAllQryExe;
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

    @Resource
    private FileListAllQryExe fileListAllQryExe;

    @Resource
    private FileFindByIdQryExe fileFindByIdQryExe;
    @Resource
    private FileFindPageQryExe fileFindPageQryExe;

    @PostConstruct
    private void initialize() {
        scenario = BizScenario.valueOf(provider);
    }

    @Override
    public SingleResponse<FileDownloadDTO> download(FileDownloadCmd cmd) {
        cmd.setBizScenario(scenario);
        return fileDownloadCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<FileUploadDTO> upload(FileUploadCmd cmd) {
        cmd.setBizScenario(scenario);
        return fileUploadCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<FileDTO> findById(IdQuery query) {
        return fileFindByIdQryExe.execute(query);
    }


    @Override
    public PageResponse<FileDTO> findPage(FilePageQuery query) {
        return fileFindPageQryExe.execute(query);
    }

    @Override
    public MultiResponse<FileDTO> findAll(FileQuery query) {
        return fileListAllQryExe.execute(query);
    }

    @Override
    public Response delete(FileDeleteCmd cmd) {
        return fileDeleteCmdExe.execute(cmd);
    }

}