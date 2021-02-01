package com.github.surgeon;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.api.DictServiceI;
import com.github.surgeon.dto.DictSaveCmd;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.dto.query.NameQuery;
import com.github.surgeon.executor.DictDeleteCmdExe;
import com.github.surgeon.executor.DictSaveExe;
import com.github.surgeon.executor.query.DictFindByIdQryExe;
import com.github.surgeon.executor.query.DictListAllQryExe;
import com.github.surgeon.executor.query.DictListByNameQryExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CatchAndLog
public class DictServiceImpl implements DictServiceI {

    @Resource
    private DictSaveExe      dictSaveExe;
    @Resource
    private DictDeleteCmdExe dictDeleteCmdExe;

    @Resource
    private DictListByNameQryExe dictListByNameQryExe;
    @Resource
    private DictListAllQryExe    dictListAllQryExe;
    @Resource
    private DictFindByIdQryExe   dictFindByIdQryExe;

    @Override
    public SingleResponse<DictDTO> findById(IdQuery query) {
        return dictFindByIdQryExe.execute(query);
    }

    @Override
    public MultiResponse<DictDTO> listByName(NameQuery fileListByNameQry) {
        return dictListByNameQryExe.execute(fileListByNameQry);
    }

    @Override
    public MultiResponse<DictDTO> findAll() {
        return dictListAllQryExe.execute();
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