
package com.github.surgeon.executor;

import com.alibaba.cola.dto.Response;
import com.github.surgeon.domain.gateway.DictGateway;
import com.github.surgeon.dto.cmd.DeleteByIdCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DictDeleteCmdExe {
    @Resource
    private DictGateway dictGateway;

    public Response execute(DeleteByIdCmd cmd) {
        dictGateway.delete(cmd.getId());
        return Response.buildSuccess();
    }

}
