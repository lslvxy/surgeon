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
package com.github.surgeon.dict.executor.query;

import com.alibaba.cola.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.surgeon.dict.Dict;
import com.github.surgeon.dict.convertor.DictDTOConvertor;
import com.github.surgeon.dict.dto.DictPageQuery;
import com.github.surgeon.dict.dto.data.DictDTO;
import com.github.surgeon.dict.gateway.DictGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class DictFindPageQryExe {

    @Resource
    private DictGateway dictGateway;
    @Resource
    private DictDTOConvertor dictDTOConvertor;

    public PageResponse<DictDTO> execute(DictPageQuery query) {
        PageHelper.startPage(query.getPageIndex(), query.getPageSize());
        List<Dict> dictList = dictGateway.findAll(query.getName());
        List<DictDTO> dictDTOList = dictDTOConvertor.toSource(dictList);
        PageInfo<DictDTO> pageInfo = new PageInfo<>(dictDTOList);
        return PageResponse.of(dictDTOList, (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }
}
