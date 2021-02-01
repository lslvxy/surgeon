
package com.github.surgeon.executor;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.github.surgeon.constant.FileProviderConstants;
import com.github.surgeon.domain.file.File;
import com.github.surgeon.domain.gateway.FileGateway;
import com.github.surgeon.dto.FileDeleteCmd;
import com.github.surgeon.extensionpoint.FileUploadExtPt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class FileDeleteCmdExe {
    @Resource
    private FileGateway       fileGateway;
    @Resource
    private ExtensionExecutor extensionExecutor;

    public Response execute(FileDeleteCmd cmd) {

        fileGateway.delete(cmd.getId());
        File file = fileGateway.findById(cmd.getId());
        cmd.setFilePath(file.getFilePath());

        if (Objects.isNull(cmd.getBizScenario())) {
            BizScenario scenario = BizScenario.valueOf(FileProviderConstants.LOCAL);
            cmd.setBizScenario(scenario);
        }
        extensionExecutor.executeVoid(FileUploadExtPt.class, cmd.getBizScenario(), v -> v.delete(cmd));
        return Response.buildSuccess();
    }

}
