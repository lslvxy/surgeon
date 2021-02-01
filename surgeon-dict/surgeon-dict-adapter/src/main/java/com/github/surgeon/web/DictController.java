package com.github.surgeon.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.github.surgeon.api.DictServiceI;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dict")
public class DictController extends BaseController {

    @Autowired
    private DictServiceI fileService;

    @PostMapping(value = "/list-by-name")
    public MultiResponse<DictDTO> listByName(@RequestParam(required = false) String name) {
        NameQuery query = new NameQuery();
        query.setName(name);
        return fileService.listByName(query);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody DictSaveCmd dictSaveCmd) {
        return Response.buildSuccess();
    }

}
