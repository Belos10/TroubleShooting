package org.telecom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.telecom.dto.RepairList;
import org.telecom.dto.TroubleDetailDto;
import org.telecom.mapper.TroubleMapper;
import org.telecom.mapper.UserMapper;
import org.telecom.pojo.Trouble;
import org.telecom.pojo.User;
import org.telecom.service.TroubleService;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
* @author Xu
* @description 针对表【trouble】的数据库操作Service实现
* @createDate 2023-08-23 16:37:20
*/
@Service
public class TroubleServiceImpl extends ServiceImpl<TroubleMapper, Trouble>
    implements TroubleService {
    @Resource
    private UserMapper userMapper;

    @Override
    public TroubleDetailDto getTroubleDetail(String manageId)
    {
        LambdaQueryWrapper<Trouble> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Trouble::getTroubleKey, manageId);
        TroubleDetailDto troubleDetailDto = new TroubleDetailDto();
        troubleDetailDto.setTrouble(getOne(lambdaQueryWrapper));
        String region = troubleDetailDto.getTrouble().getRegion();
        List<User> user = userMapper.getUserByRegion(region);
        List<RepairList> list = new ArrayList<>();
        for(User u:user){
            RepairList repairList = new RepairList();
            repairList.setRepairId(u.getId());
            repairList.setRepairName(u.getUserName());
            list.add(repairList);
        }
        troubleDetailDto.setList(list);
        return troubleDetailDto;
    }

}




