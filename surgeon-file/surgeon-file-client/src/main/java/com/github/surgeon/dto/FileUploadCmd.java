package com.github.surgeon.dto;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.extension.BizScenario;
import com.github.surgeon.dto.data.FileDTO;
import lombok.Data;

import java.io.InputStream;

@Data
public class FileUploadCmd extends Command {

    private BizScenario bizScenario;

    private String fileName;

    private FileDTO fileDTO;

    private InputStream inputStream;
}
