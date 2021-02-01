
package com.github.surgeon.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.github.surgeon.domain.Dict;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class DictDeleteCmdExe {
    @Resource
    private DictGateway       dictGateway;
    @Resource
    private ExtensionExecutor extensionExecutor;

    public Response execute(DeleteByIdCmd cmd) {

        dictGateway.delete(cmd.getId());
        Dict dict = dictGateway.findById(cmd.getId());

        return Response.buildSuccess();
    }

}
