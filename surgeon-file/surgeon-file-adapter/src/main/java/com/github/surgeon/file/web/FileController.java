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
package com.github.surgeon.file.web;

import cn.hutool.core.io.IoUtil;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.SysException;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.file.api.FileServiceI;
import com.github.surgeon.file.dto.FileDownloadCmd;
import com.github.surgeon.file.dto.FilePageQuery;
import com.github.surgeon.file.dto.FileQuery;
import com.github.surgeon.file.dto.FileUploadCmd;
import com.github.surgeon.file.dto.data.FileDTO;
import com.github.surgeon.file.dto.data.FileDownloadDTO;
import com.github.surgeon.file.dto.data.FileUploadDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("file")
@Api(tags = "文件管理")
public class FileController extends BaseController {

    @Autowired
    private FileServiceI fileService;

    @GetMapping(value = "/list")
    public MultiResponse<FileDTO> list(FileQuery query) {
        return fileService.findAll(query);
    }

    @GetMapping(value = "/page")
    public PageResponse<FileDTO> page(FilePageQuery query) {
        return fileService.findPage(query);
    }

    @GetMapping(value = "/detail")
    public SingleResponse<FileDTO> detail(IdQuery query) {
        return fileService.findById(query);
    }

    @PostMapping("upload")
    @ApiOperation(value = "上传", response = Response.class)
    public SingleResponse<FileUploadDTO> upload(@RequestParam("file") MultipartFile file) throws IOException {

        FileUploadCmd cmd = new FileUploadCmd();
        FileDTO dto = new FileDTO();
        dto.setFileName(file.getOriginalFilename());
        dto.setFileSize(file.getSize());
        dto.setMd5(DigestUtils.md5DigestAsHex(file.getBytes()));
        dto.setContentType(file.getContentType());

        cmd.setFileDTO(dto);
        cmd.setInputStream(file.getInputStream());
        return fileService.upload(cmd);
    }

    @GetMapping("download/{id}")
    @ApiOperation(value = "下载", response = Response.class)
    public void download(@PathVariable Long id, HttpServletResponse response) {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setId(id);
        SingleResponse<FileDownloadDTO> dto = fileService.download(cmd);

        if (!dto.isSuccess()) {
            throw new SysException(dto.getErrMessage());
        }
        InputStream inputStream = dto.getData().getFileInputStream();
        try {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(dto.getData().getFileName(), "UTF-8"));
            IoUtil.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IoUtil.close(inputStream);
        }
    }
}
