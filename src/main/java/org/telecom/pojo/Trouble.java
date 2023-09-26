package org.telecom.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.telecom.utils.ExcelImport;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@TableName(value = "trouble")
@Data
public class Trouble {
    @TableId(type = IdType.AUTO)
    private BigInteger troubleId;
    //订单标识
    @TableField("trouble_key")
    private String troubleKey;
    @ExcelImport("电话")
    private String phone;
    @ExcelImport("地址")
    private String address;
    //点单时间
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @ExcelImport("上传时间")
    private LocalDate submitTime;
    private String pic;
    @ExcelImport("备注")
    private String remark;
    @ExcelImport("姓名")
    @TableField("trouble_name")
    private String troubleName;
    @ExcelImport("地区")
    private String region;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
