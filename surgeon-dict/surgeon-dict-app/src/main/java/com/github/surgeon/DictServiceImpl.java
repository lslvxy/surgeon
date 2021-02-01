package com.github.surgeon;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.github.surgeon.api.DictServiceI;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import com.github.surgeon.dto.data.DictDTO;
import com.github.surgeon.executor.DictDeleteCmdExe;
import com.github.surgeon.executor.DictSaveExe;
import com.github.surgeon.executor.query.FileFindByIdQryExe;
import com.github.surgeon.executor.query.FileListAllQryExe;
import com.github.surgeon.executor.query.FileListByNameQryExe;
import com.github.surgeon.dto.query.IdQuery;
import com.github.surgeon.dto.query.NameQuery;
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
    private FileListByNameQryExe fileListByNameQryExe;
    @Resource
    private FileListAllQryExe    fileListAllQryExe;
    @Resource
    private FileFindByIdQryExe   fileFindByIdQryExe;

    @Override
    public SingleResponse<DictDTO> findById(IdQuery query) {
        return fileFindByIdQryExe.execute(query);
    }

    @Override
    public MultiResponse<DictDTO> listByName(NameQuery fileListByNameQry) {
        return fileListByNameQryExe.execute(fileListByNameQry);
    }

    @Override
    public MultiResponse<DictDTO> findAll() {
        return fileListAllQryExe.execute();
    }

    @Override
    public Response delete(DeleteByIdCmd cmd) {
        return dictDeleteCmdExe.execute(cmd);
    }

}