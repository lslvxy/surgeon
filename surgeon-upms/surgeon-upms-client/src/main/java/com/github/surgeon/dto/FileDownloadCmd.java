package com.github.surgeon.dto;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.extension.BizScenario;
import lombok.Data;

import java.io.InputStream;

@Data
public class FileDownloadCmd extends Command {

    private BizScenario bizScenario;

    private String filePath;

    private InputStream inputStream;

}
