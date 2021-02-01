package com.github.surgeon.dto.cmd;

import com.alibaba.cola.dto.Command;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class FindByIdCmd extends Command {
    private Long id;

}
