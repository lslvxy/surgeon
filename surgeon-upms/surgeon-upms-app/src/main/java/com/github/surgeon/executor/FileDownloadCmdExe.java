
package com.github.surgeon.executor;

import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.github.surgeon.constant.Constants;
import com.github.surgeon.dto.FileDownloadCmd;
import com.github.surgeon.dto.data.FileDownloadDTO;
import com.github.surgeon.extensionpoint.FileUploadExtPt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;

@Component
public class FileDownloadCmdExe {

    @Resource
    private ExtensionExecutor extensionExecutor;

    public SingleResponse<FileDownloadDTO> execute(FileDownloadCmd cmd) {

        if (Objects.isNull(cmd.getBizScenario())) {
            BizScenario scenario = BizScenario.valueOf(Constants.LOCAL);
            cmd.setBizScenario(scenario);
        }
        FileDownloadDTO execute = extensionExecutor.execute(FileUploadExtPt.class, cmd.getBizScenario(), v -> v.download(cmd));
        return SingleResponse.of(execute);
    }

}
