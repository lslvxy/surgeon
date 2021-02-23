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

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.github.surgeon.api.DictServiceI;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.DictPageQuery;
import com.github.surgeon.dto.DictQuery;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dict")
public class DictController extends BaseController {

    @Autowired
    private DictServiceI dictServiceI;

    @GetMapping(value = "page")
    public PageResponse<DictDTO> page(DictPageQuery query) {
        return dictServiceI.findPage(query);
    }

    @GetMapping(value = "all")
    public MultiResponse<DictDTO> all() {
        return dictServiceI.findAll();
    }

    @GetMapping(value = "list")
    public MultiResponse<DictDTO> list(DictQuery query) {
        return dictServiceI.findAll(query);
    }

    @GetMapping(value = "detail")
    public Response detail(IdQuery query) {
        return dictServiceI.findById(query);
    }

    @PostMapping(value = "save")
    public Response save(@Validated @RequestBody DictSaveCmd cmd) {
        return dictServiceI.create(cmd);
    }

    @PostMapping(value = "delete")
    public Response delete(@RequestBody DeleteByIdCmd cmd) {
        return dictServiceI.delete(cmd);
    }

}
