package org.telecom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.telecom.pojo.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Xu
* @description 针对表【repair】的数据库操作Mapper
* @createDate 2023-08-23 08:30:19
* @Entity org.telecom.pojo.Repair
*/
@Mapper
public interface RepairMapper extends BaseMapper<Repair> {

}




