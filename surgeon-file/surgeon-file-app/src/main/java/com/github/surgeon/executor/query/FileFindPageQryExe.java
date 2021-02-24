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
package com.github.surgeon.executor.query;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.cola.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.surgeon.convertor.FileDTOConvertor;
import com.github.surgeon.domain.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.dto.FilePageQuery;
import com.github.surgeon.dto.FileQuery;
import com.github.surgeon.dto.data.FileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class FileFindPageQryExe {

    @Resource
    private FileGateway fileGateway;
    @Autowired
    private FileDTOConvertor fileDTOConvertor;

    public PageResponse<FileDTO> execute(FilePageQuery query) {
        PageHelper.startPage(query.getPageIndex(), query.getPageSize());
        List<File> list = fileGateway.findAll(BeanUtil.copyProperties(query, FileQuery.class));
        List<FileDTO> dtoList = fileDTOConvertor.toSource(list);
        PageInfo<FileDTO> pageInfo = new PageInfo<>(dtoList);
        return PageResponse.of(dtoList, (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }
}
