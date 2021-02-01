package com.github.surgeon.dto;

import com.alibaba.cola.dto.Command;
import com.github.surgeon.dto.data.DictDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictDetailSaveCmd extends Command {

    private DictDetailDTO dictDetailDTO;

}
