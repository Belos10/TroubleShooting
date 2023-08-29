package org.telecom.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.telecom.pojo.Repair;
import org.telecom.service.RepairService;
import org.telecom.mapper.RepairMapper;
import org.springframework.stereotype.Service;

/**
* @author Xu
* @description 针对表【repair】的数据库操作Service实现
* @createDate 2023-08-23 08:30:19
*/
@Service
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair>
    implements RepairService{

}




