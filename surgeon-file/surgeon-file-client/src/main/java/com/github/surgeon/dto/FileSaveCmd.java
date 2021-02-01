package com.github.surgeon.dto;

import com.alibaba.cola.dto.Command;
import com.github.surgeon.dto.data.FileDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileSaveCmd extends Command {

    private FileDTO fileDTO;

}
