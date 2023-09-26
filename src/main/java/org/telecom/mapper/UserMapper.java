package org.telecom.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.telecom.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getUserPage(int page, int pageSize);
    int getUserPageCount();

    List<User> getUserByRegion(String region);
}




