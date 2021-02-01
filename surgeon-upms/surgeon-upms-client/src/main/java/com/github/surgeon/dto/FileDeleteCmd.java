package com.github.surgeon.dto;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.extension.BizScenario;
import lombok.Data;

@Data
public class FileDeleteCmd extends Command {

    private Long        id;
    private String      filePath;
    private BizScenario bizScenario;

}
