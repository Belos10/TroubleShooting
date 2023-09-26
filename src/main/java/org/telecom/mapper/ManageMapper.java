package org.telecom.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.telecom.pojo.Manage;

import java.time.LocalDate;
import java.util.List;

/**
* @author Xu
* @description 针对表【manage】的数据库操作Mapper
* @createDate 2023-08-23 10:46:33
* @Entity .Manage
*/
@Mapper
public interface ManageMapper extends BaseMapper<Manage> {
    List<Manage> getManagePageRepair(int page, int pageSize, int id, int status);
    int getMealPageCountRepair(int id, int status);
    int getMealPageCountN(String time);
    List<Manage> getManagePageN(int page, int pageSize, String time);
    int getMealPageCountY(String time);
    List<Manage> getManagePageY(int page, int pageSize, String time);

}




