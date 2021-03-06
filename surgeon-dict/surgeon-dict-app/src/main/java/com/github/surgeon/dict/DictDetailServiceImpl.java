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

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.dict.api.DictDetailServiceI;
import com.github.surgeon.dict.dto.DictDetailPageQuery;
import com.github.surgeon.dict.dto.DictDetailQuery;
import com.github.surgeon.dict.dto.DictDetailSaveCmd;
import com.github.surgeon.dict.dto.data.DictDetailDTO;
import com.github.surgeon.dict.executor.DictDetailDeleteCmdExe;
import com.github.surgeon.dict.executor.DictDetailSaveExe;
import com.github.surgeon.dict.executor.query.DictDetailFindByIdQryExe;
import com.github.surgeon.dict.executor.query.DictDetailListQryExe;
import com.github.surgeon.dict.executor.query.DictDetailPageQryExe;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.query.IdQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("dictDetailServiceImpl")
@CatchAndLog
public class DictDetailServiceImpl implements DictDetailServiceI {

    @Resource
    private DictDetailSaveExe dictDetailSaveExe;
    @Resource
    private DictDetailDeleteCmdExe dictDetailDeleteCmdExe;

    @Resource
    private DictDetailPageQryExe dictDetailPageQryExe;
    @Resource
    private DictDetailListQryExe dictDetailListQryExe;
    @Resource
    private DictDetailFindByIdQryExe dictDetailFindByIdQryExe;

    @Override
    public SingleResponse<DictDetailDTO> findById(IdQuery query) {
        return dictDetailFindByIdQryExe.execute(query);
    }

    @Override
    public PageResponse<DictDetailDTO> findPage(DictDetailPageQuery query) {
        return dictDetailPageQryExe.execute(query);
    }

    @Override
    public MultiResponse<DictDetailDTO> findAll(DictDetailQuery query) {
        return dictDetailListQryExe.execute(query);
    }

    @Override
    public MultiResponse<DictDetailDTO> findAll() {
        return dictDetailListQryExe.execute(new DictDetailQuery());
    }

    @Override
    public Response delete(DeleteByIdCmd cmd) {
        return dictDetailDeleteCmdExe.execute(cmd);
    }

    @Override
    public SingleResponse<DictDetailDTO> create(DictDetailSaveCmd cmd) {
        return dictDetailSaveExe.execute(cmd);
    }

    @Override
    public SingleResponse<DictDetailDTO> update(DictDetailSaveCmd cmd) {
        return dictDetailSaveExe.execute(cmd);
    }

}