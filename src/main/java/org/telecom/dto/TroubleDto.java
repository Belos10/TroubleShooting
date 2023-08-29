package org.telecom.dto;

import lombok.Data;
import org.telecom.pojo.Trouble;
import org.telecom.utils.ExcelImport;

import java.time.LocalDate;

@Data
public class TroubleDto extends Trouble {
    private Trouble trouble;

    @ExcelImport("故障单状态")
    private int status;

    @ExcelImport("返单备注")
    private String mana_remark;
}
