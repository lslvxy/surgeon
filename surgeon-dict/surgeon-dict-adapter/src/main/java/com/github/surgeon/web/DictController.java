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
import com.alibaba.cola.dto.Response;
import com.github.surgeon.api.DictServiceI;
import com.github.surgeon.base.BaseController;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.NameQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dict")
public class DictController extends BaseController {

    @Autowired
    private DictServiceI dictServiceI;

    @PostMapping(value = "/list-by-name")
    public MultiResponse<DictDTO> listByName(@RequestBody NameQuery query) {
        return dictServiceI.listByName(query);
    }

    @PostMapping(value = "/page")
    public Response page(@RequestBody DictSaveCmd dictSaveCmd) {
        return Response.buildSuccess();
    }

    @PostMapping(value = "/all")
    public Response all(@RequestBody DictSaveCmd dictSaveCmd) {
        return Response.buildSuccess();
    }

    @PostMapping(value = "/list")
    public MultiResponse<DictDTO> list(@RequestBody NameQuery query) {
        return dictServiceI.listByName(query);
    }

    @PostMapping(value = "/detail")
    public Response detail(@RequestBody DictSaveCmd dictSaveCmd) {
        return Response.buildSuccess();
    }

    @PostMapping(value = "/save")
    public Response save(@RequestBody DictSaveCmd dictSaveCmd) {
        return Response.buildSuccess();
    }

    @PostMapping(value = "/delete")
    public Response delete(@RequestBody DictSaveCmd dictSaveCmd) {
        return Response.buildSuccess();
    }

}
