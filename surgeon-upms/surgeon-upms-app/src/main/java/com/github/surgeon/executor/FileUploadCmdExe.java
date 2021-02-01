
package com.github.surgeon.executor;

import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.github.surgeon.constant.Constants;
import com.github.surgeon.dto.FileUploadCmd;
import com.github.surgeon.dto.data.FileUploadDTO;
import com.github.surgeon.extensionpoint.FileUploadExtPt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class FileUploadCmdExe {

    @Resource
    private ExtensionExecutor extensionExecutor;

    public FileUploadDTO execute(FileUploadCmd cmd) {

        if (Objects.isNull(cmd.getBizScenario())) {
            BizScenario scenario = BizScenario.valueOf(Constants.LOCAL);
            cmd.setBizScenario(scenario);
        }
        return extensionExecutor.execute(FileUploadExtPt.class, cmd.getBizScenario(), v -> v.upload(cmd));
    }

}
