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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Autowired
    private FileServiceI fileService;

    @GetMapping(value = "/list-by-name")
    public MultiResponse<FileDTO> listByName(@RequestParam(required = false) String name) {
        NameQuery query = new NameQuery();
        query.setName(name);
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
