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
import com.github.surgeon.api.DictDetailServiceI;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.DictDetailPageQuery;
import com.github.surgeon.dto.DictDetailQuery;
import com.github.surgeon.dto.DictDetailSaveCmd;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDetailDTO;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dict-detail")
public class DictDetailController extends BaseController {

    @Autowired
    private DictDetailServiceI dictDetailServiceI;

    @GetMapping(value = "page")
    public PageResponse<DictDetailDTO> page(DictDetailPageQuery query) {
        return dictDetailServiceI.findPage(query);
    }

    @GetMapping(value = "all")
    public MultiResponse<DictDetailDTO> all() {
        return dictDetailServiceI.findAll();
    }

    @GetMapping(value = "list")
    public MultiResponse<DictDetailDTO> list(DictDetailQuery query) {
        return dictDetailServiceI.findAll(query);
    }

    @GetMapping(value = "detail")
    public Response detail(IdQuery query) {
        return dictDetailServiceI.findById(query);
    }

    @PostMapping(value = "save")
    public Response save(@RequestBody DictDetailSaveCmd cmd) {
        return dictDetailServiceI.create(cmd);
    }

    @PostMapping(value = "delete")
    public Response delete(@RequestBody DeleteByIdCmd cmd) {
        return dictDetailServiceI.delete(cmd);
    }

}
