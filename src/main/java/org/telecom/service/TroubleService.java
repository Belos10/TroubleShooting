package org.telecom.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.telecom.dto.TroubleDetailDto;
import org.telecom.pojo.Trouble;

/**
* @author Xu
* @description 针对表【trouble】的数据库操作Service
* @createDate 2023-08-23 16:37:20
*/
public interface TroubleService extends IService<Trouble> {
    TroubleDetailDto getTroubleDetail(String manageId);
}
