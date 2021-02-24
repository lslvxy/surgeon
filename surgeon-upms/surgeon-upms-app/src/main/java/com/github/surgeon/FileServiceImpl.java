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
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.SysException;
import com.alibaba.cola.extension.BizScenario;
import com.github.surgeon.api.FileServiceI;
import com.github.surgeon.dto.FileDeleteCmd;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.FileSaveCmd;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.dto.query.NameQuery;
import com.github.surgeon.executor.FileDeleteCmdExe;
import com.github.surgeon.executor.FileDownloadCmdExe;
import com.github.surgeon.executor.FileSaveExe;
import com.github.surgeon.executor.FileUploadCmdExe;
import com.github.surgeon.executor.query.FileFindByIdQryExe;
import com.github.surgeon.executor.query.FileListAllQryExe;
import com.github.surgeon.executor.query.FileListByNameQryExe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

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
    private FileSaveExe fileSaveExe;
    @Resource
    private FileDeleteCmdExe fileDeleteCmdExe;

    @Resource
    private FileListByNameQryExe fileListByNameQryExe;
    @Resource
    private FileListAllQryExe fileListAllQryExe;
    @Resource
    private FileFindByIdQryExe fileFindByIdQryExe;

    @PostConstruct
    private void initialize() {
        scenario = BizScenario.valueOf(provider);
    }

    @Override
    public SingleResponse<FileDownloadDTO> download(Long id) {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setBizScenario(scenario);
        return fileDownloadCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<FileUploadDTO> upload(MultipartFile file) {
        try {
            FileUploadCmd cmd = new FileUploadCmd();
            cmd.setBizScenario(scenario);
            cmd.setFileName(file.getOriginalFilename());
            cmd.setInputStream(file.getInputStream());

            FileUploadDTO uploadResult = fileUploadCmdExe.execute(cmd);

            FileDTO fileDTO = new FileDTO();
            fileDTO.setFileName(file.getOriginalFilename());
            fileDTO.setFilePath(uploadResult.getFilePath());
            fileDTO.setFileSize(file.getSize());
            fileDTO.setContentType(file.getContentType());
            fileDTO.setMd5(DigestUtils.md5DigestAsHex(file.getBytes()));

            FileSaveCmd fileSaveCmd = new FileSaveCmd();
            fileSaveCmd.setFileDTO(fileDTO);

            fileDTO = fileSaveExe.execute(fileSaveCmd);

            uploadResult.setId(fileDTO.getId());
            uploadResult.setFileUrl("/file/download/" + uploadResult.getId());

            return SingleResponse.of(uploadResult);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("上传失败");
        }
    }

    @Override
    public SingleResponse<FileDTO> findById(IdQuery query) {
        return fileFindByIdQryExe.execute(query);
    }

    @Override
    public MultiResponse<FileDTO> listByName(NameQuery fileListByNameQry) {
        return fileListByNameQryExe.execute(fileListByNameQry);
    }

    @Override
    public MultiResponse<FileDTO> findAll() {
        return fileListAllQryExe.execute();
    }

    @Override
    public Response delete(FileDeleteCmd cmd) {
        return fileDeleteCmdExe.execute(cmd);
    }

}