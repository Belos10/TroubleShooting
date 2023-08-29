package org.telecom.controller;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.telecom.common.R;
import org.telecom.dto.TroubleDto;
import org.telecom.pojo.Manage;
import org.telecom.pojo.Trouble;
import org.telecom.service.ManageService;
import org.telecom.service.TroubleService;
import org.telecom.utils.ExcelUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/manage")
public class ManageController {
    @Resource
    private ManageService manageService;
    @Resource
    private TroubleService troubleService;

    //故障展示 按时间（未完成）
    @GetMapping("/pagen")
    public R<Page<Manage>> getManagePageN(int page, int pageSize,
                                          @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate time) {
        return R.success(manageService.getManagePageN((page - 1) * pageSize, pageSize, time));
    }

    //故障展示 按时间（已完成）
    @GetMapping("/pagey")
    public R<Page<Manage>> getManagePageY(int page, int pageSize,
                                          @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate time) {
        return R.success(manageService.getManagePageY((page - 1) * pageSize, pageSize, time));
    }

    //查看故障详情 （包括维修界面）
    @PostMapping("/detail")
    public R<Trouble> getTroubleDetail(String manageId){
        return R.success(troubleService.getTroubleDetail(manageId));
    }

    //导出excel
    @PostMapping("/expExl")
    public void exportExcel(@RequestBody List<Integer> idList, HttpServletResponse response) throws Exception{
        manageService. exportExcel(idList, response);
    }

}
