package org.telecom.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.telecom.common.R;
import org.telecom.pojo.Manage;
import org.telecom.service.ManageService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;

//维修人员界面
@RestController
@Slf4j
@RequestMapping("/repair")
public class RepairController {
    @Resource
    private ManageService manageService;

    //展示故障单  故障单详情见ManageController
    @GetMapping("/page")
    public R<Page<Manage>> getRepairPage(int page, int pageSize, HttpSession session) {
        int id = (int) session.getAttribute("loginUser");
        return R.success(manageService.getManagePageRepair((page - 1) * pageSize, pageSize, id, 2));
    }

    //返回结果
    @PostMapping("/submit")
    public R<String> submitResult(@RequestBody Manage manage, HttpSession session){
        manage.setManageId(manage.getManageId());
        manage.setHandlerId(BigInteger.valueOf((Long) session.getAttribute("loginUser")));
        manageService.saveOrUpdate(manage);
        return R.success("提交成功");
    }
}
