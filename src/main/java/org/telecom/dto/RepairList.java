package org.telecom.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class RepairList
{
    private BigInteger repairId;
    private String repairName;
}
