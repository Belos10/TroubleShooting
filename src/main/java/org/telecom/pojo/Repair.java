package org.telecom.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;

/**
 * 
 * @TableName repair
 */
@TableName(value ="repair")
@Data
public class Repair implements Serializable {
    /**
     * 用管理单id作为主键
     */
    @TableId
    private BigInteger manageId;

    /**
     * 
     */
    private BigInteger handlerId;

    /**
     * 维修返图
     */
    private String repairPic;

    /**
     * 维修备注
     */
    private String repairRemark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Repair other = (Repair) that;
        return (this.getManageId() == null ? other.getManageId() == null : this.getManageId().equals(other.getManageId()))
            && (this.getHandlerId() == null ? other.getHandlerId() == null : this.getHandlerId().equals(other.getHandlerId()))
            && (this.getRepairPic() == null ? other.getRepairPic() == null : this.getRepairPic().equals(other.getRepairPic()))
            && (this.getRepairRemark() == null ? other.getRepairRemark() == null : this.getRepairRemark().equals(other.getRepairRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getManageId() == null) ? 0 : getManageId().hashCode());
        result = prime * result + ((getHandlerId() == null) ? 0 : getHandlerId().hashCode());
        result = prime * result + ((getRepairPic() == null) ? 0 : getRepairPic().hashCode());
        result = prime * result + ((getRepairRemark() == null) ? 0 : getRepairRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", manageId=").append(manageId);
        sb.append(", handlerId=").append(handlerId);
        sb.append(", repairPic=").append(repairPic);
        sb.append(", repairRemark=").append(repairRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}