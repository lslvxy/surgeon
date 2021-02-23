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
package com.github.surgeon;

import cn.hutool.core.lang.Assert;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.api.DictServiceI;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.dto.DictPageQuery;
import com.github.surgeon.dto.DictQuery;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.FindByFieldQuery;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.executor.DictDeleteCmdExe;
import com.github.surgeon.executor.DictSaveExe;
import com.github.surgeon.executor.query.DictFindByFieldQryExe;
import com.github.surgeon.executor.query.DictFindByIdQryExe;
import com.github.surgeon.executor.query.DictFindListQryExe;
import com.github.surgeon.executor.query.DictFindPageQryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service("dictServiceImpl")
@CatchAndLog
public class DictServiceImpl implements DictServiceI {

    @Resource
    private DictSaveExe dictSaveExe;
    @Resource
    private DictDeleteCmdExe dictDeleteCmdExe;

    @Resource
    private DictFindPageQryExe dictFindPageQryExe;
    @Resource
    private DictFindListQryExe dictFindListQryExe;
    @Resource
    private DictFindByIdQryExe dictFindByIdQryExe;
    @Resource
    private DictFindByFieldQryExe dictFindByFieldQryExe;

    @Override
    public boolean createValueExists(Object value, String fieldName) throws UnsupportedOperationException {
        Assert.notBlank(fieldName);
        if (value == null) {
            return false;
        }
        Dict byField = findByField(new FindByFieldQuery(fieldName, value.toString()));
        return !Objects.isNull(byField);
    }

    @Override
    public boolean updateValueExists(Object value, String fieldName, Object id) throws UnsupportedOperationException {
        Assert.notBlank(fieldName);
        if (value == null) {
            return false;
        }
        Dict byField = findByField(new FindByFieldQuery(fieldName, value.toString()));
        return !(Objects.isNull(byField) || Objects.equals(byField.getId(), id));
    }

    public Dict findByField(FindByFieldQuery query) {
        return dictFindByFieldQryExe.execute(query);
    }

    @Override
    public SingleResponse<DictDTO> findById(IdQuery query) {
        return dictFindByIdQryExe.execute(query);
    }

    @Override
    public PageResponse<DictDTO> findPage(DictPageQuery query) {
        return dictFindPageQryExe.execute(query);
    }

    @Override
    public MultiResponse<DictDTO> findAll(DictQuery query) {
        return dictFindListQryExe.execute(query);
    }

    @Override
    public MultiResponse<DictDTO> findAll() {
        return dictFindListQryExe.execute(new DictQuery());
    }

    @Override
    public Response delete(DeleteByIdCmd cmd) {
        return dictDeleteCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<DictDTO> create(DictSaveCmd cmd) {
        return dictSaveExe.execute(cmd);
    }

    @Override
    public SingleResponse<DictDTO> update(DictSaveCmd cmd) {
        return dictSaveExe.execute(cmd);
    }

}