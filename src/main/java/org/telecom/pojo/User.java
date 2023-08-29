package org.telecom.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * 管理员账户
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable
{
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
    //id
    @TableId(type = IdType.AUTO)
    private BigInteger id;
    //账户
    @TableField("acct")
    private String account;
    //密码
    @TableField("pwd")
    private String password;
    @TableField("user_name")
    private String name;
    @TableField("user_level")
    private int level;   //0:管理员 1：维修人员
    private String phone;
}