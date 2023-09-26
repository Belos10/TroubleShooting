package org.telecom.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telecom.common.R;
import org.telecom.pojo.Manage;
import org.telecom.pojo.Trouble;
import org.telecom.service.ManageService;
import org.telecom.service.TroubleService;
import org.telecom.utils.FirstLetterUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@Slf4j
@RequestMapping("/trouble")
public class TroubleController {

    @Resource
    private TroubleService troubleService;
    @Resource
    private ManageService manageService;

    //上传故障
    @PostMapping("/addTrouble")
    public R<String> addTrouble(@RequestBody Trouble trouble) throws Exception
    {
        String region = FirstLetterUtils.getFirstLetterOptimized(trouble.getRegion());
        String time = LocalDateTime.now().toString();
        String key = time + region;
        trouble.setTroubleKey(key);
        Manage manage = new Manage();
        manage.setManageId(key);
        troubleService.save(trouble);
        manageService.save(manage);
        return R.success("上传成功");
    }
}
