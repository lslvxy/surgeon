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
package com.github.surgeon.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.api.FileServiceI;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.FileSaveCmd;
import com.github.surgeon.dto.data.FileDTO;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.dto.query.NameQuery;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Autowired
    private FileServiceI fileService;

    @PostMapping(value = "/list-by-name")
    public MultiResponse<FileDTO> listByName(@RequestBody NameQuery query) {
        return fileService.listByName(query);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody FileSaveCmd fileSaveCmd) {
        return Response.buildSuccess();
    }

    @PostMapping("upload")
    @ApiOperation(value = "上传", response = Response.class)
    public Response upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        if (file.isEmpty()) {

            return Response.buildFailure("500", "上传失败，请选择文件");
        }
        SingleResponse<FileUploadDTO> upload = fileService.upload(file);
        return upload;
    }
}
