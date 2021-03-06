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
package com.github.surgeon.dict;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dict.api.DictServiceI;
import com.github.surgeon.dict.dto.DictPageQuery;
import com.github.surgeon.dict.dto.DictQuery;
import com.github.surgeon.dict.dto.DictSaveCmd;
import com.github.surgeon.dict.dto.data.DictDTO;
import com.github.surgeon.dict.executor.DictDeleteCmdExe;
import com.github.surgeon.dict.executor.DictSaveExe;
import com.github.surgeon.dict.executor.query.DictFindByFieldQryExe;
import com.github.surgeon.dict.executor.query.DictFindByIdQryExe;
import com.github.surgeon.dict.executor.query.DictFindListQryExe;
import com.github.surgeon.dict.executor.query.DictFindPageQryExe;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.query.FindByFieldQuery;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("dictServiceImpl")
@CatchAndLog
@CacheConfig(cacheNames = "dictCache")
public class DictServiceImpl implements DictServiceI {

    @Resource
    private DictSaveExe      dictSaveExe;
    @Resource
    private DictDeleteCmdExe dictDeleteCmdExe;

    @Resource
    private DictFindPageQryExe    dictFindPageQryExe;
    @Resource
    private DictFindListQryExe    dictFindListQryExe;
    @Resource
    private DictFindByIdQryExe    dictFindByIdQryExe;
    @Resource
    private DictFindByFieldQryExe dictFindByFieldQryExe;

    @Override
    public boolean fieldValueExists(Map<String, Object> fieldMap, Object id) throws UnsupportedOperationException {
        Assert.notEmpty(fieldMap);
        FindByFieldQuery query = new FindByFieldQuery(fieldMap);
        Dict dict = dictFindByFieldQryExe.execute(query);
        if (ObjectUtil.isNull(id)) {
            return ObjectUtil.isNotNull(dict);
        }
        return ObjectUtil.notEqual(dict.getId(), id);
    }

    @Override
    @Cacheable(key = "#query.id")
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