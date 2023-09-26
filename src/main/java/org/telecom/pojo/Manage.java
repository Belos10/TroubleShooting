package org.telecom.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;

@TableName(value = "manage")
@Data
public class Manage {
    @TableId
    private String manageId;
    //订单标识
    private BigInteger handlerId;
    //0:未查看
    //1:已查看 未处理
    //2:已派单 未完成
    //3:已完成
    //4:无需处理
    @TableField("mana_status")
    private int manaStatus;
    private String manaRemark;
    private String manaPic;

}
