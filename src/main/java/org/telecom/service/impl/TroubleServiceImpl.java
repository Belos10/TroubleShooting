package org.telecom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.telecom.mapper.TroubleMapper;
import org.telecom.pojo.Trouble;
import org.telecom.service.TroubleService;

/**
* @author Xu
* @description 针对表【trouble】的数据库操作Service实现
* @createDate 2023-08-23 16:37:20
*/
@Service
public class TroubleServiceImpl extends ServiceImpl<TroubleMapper, Trouble>
    implements TroubleService {

    @Override
    public Trouble getTroubleDetail(String manageId)
    {
        LambdaQueryWrapper<Trouble> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Trouble::getKey, manageId);
        return getOne(lambdaQueryWrapper);
    }

}




