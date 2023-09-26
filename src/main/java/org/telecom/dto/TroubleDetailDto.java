package org.telecom.dto;

import lombok.Data;
import org.telecom.pojo.Trouble;

import java.util.List;

@Data
public class TroubleDetailDto
{
    private Trouble trouble;
    List<RepairList> list;
}

