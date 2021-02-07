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
package com.github.surgeon.web;

import cn.hutool.core.io.IoUtil;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.exception.SysException;
import com.github.surgeon.api.FileServiceI;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.FileSearchQuery;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.google.common.base.Joiner;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Autowired
    private FileServiceI fileService;

    @PostMapping(value = "/list")
    public MultiResponse<FileDTO> list(@RequestBody FileSearchQuery query) {
        return fileService.findAll(query);
    }


    @PostMapping("upload")
    @ApiOperation(value = "上传", response = Response.class)
    public SingleResponse<FileUploadDTO> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        FileUploadCmd cmd = new FileUploadCmd();
        cmd.setFileName(file.getOriginalFilename());
        cmd.setSize(file.getSize());
        cmd.setInputStream(file.getInputStream());
        return fileService.upload(cmd);
    }

    @GetMapping("download/{file}")
    @ApiOperation(value = "下载", response = Response.class)
    public void download(@PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(file);
        doDownload(cmd, response);
    }

    @GetMapping("download")
    public void downloadparam(@RequestParam String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(file);
        doDownload(cmd, response);
    }

    @GetMapping("download/{path}/{file}")
    public void download2(@PathVariable String path, @PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(Joiner.on("/").join(path, file));
        doDownload(cmd, response);
    }

    @GetMapping("download/{path1}/{path2}/{file}")
    public void download3(@PathVariable String path1, @PathVariable String path2, @PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(Joiner.on("/").join(path1, path2, file));
        doDownload(cmd, response);
    }

    @GetMapping("download/{path1}/{path2}/{path3}/{file}")
    public void download4(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3, @PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(Joiner.on("/").join(path1, path2, path3, file));
        doDownload(cmd, response);
    }

    @GetMapping("download/{path1}/{path2}/{path3}/{path4}/{file}")
    public void download4(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3, @PathVariable String path4, @PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(Joiner.on("/").join(path1, path2, path3, path4, file));
        doDownload(cmd, response);
    }

    @GetMapping("download/{path1}/{path2}/{path3}/{path4}/{path5}/{file}")
    public void download5(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3, @PathVariable String path4, @PathVariable String path5, @PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(Joiner.on("/").join(path1, path2, path3, path4, path5, file));
        doDownload(cmd, response);
    }

    @GetMapping("download/{path1}/{path2}/{path3}/{path4}/{path5}/{path6}/{file}")
    public void download6(@PathVariable String path1, @PathVariable String path2, @PathVariable String path3, @PathVariable String path4, @PathVariable String path5, @PathVariable String path6, @PathVariable String file, HttpServletResponse response) throws IOException {
        FileDownloadCmd cmd = new FileDownloadCmd();
        cmd.setFilePath(Joiner.on("/").join(path1, path2, path3, path4, path5, path6, file));
        doDownload(cmd, response);
    }

    private void doDownload(FileDownloadCmd cmd, HttpServletResponse response) {
        if (!cmd.getFilePath().startsWith("/")) {
            cmd.setFilePath("/" + cmd.getFilePath());
        }
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
