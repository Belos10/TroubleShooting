package org.telecom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.telecom.pojo.Trouble;

/**
* @author Xu
* @description 针对表【trouble】的数据库操作Mapper
* @createDate 2023-08-23 16:37:20
* @Entity .Trouble
*/
@Mapper
public interface TroubleMapper extends BaseMapper<Trouble> {

}




