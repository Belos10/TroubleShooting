package org.telecom.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.telecom.dto.TroubleDto;
import org.telecom.pojo.Manage;
import org.springframework.stereotype.Service;
import org.telecom.mapper.ManageMapper;
import org.telecom.pojo.Trouble;
import org.telecom.pojo.User;
import org.telecom.service.ManageService;
import org.telecom.service.TroubleService;
import org.telecom.utils.ExcelUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author Xu
* @description 针对表【manage】的数据库操作Service实现
* @createDate 2023-08-23 10:46:33
*/
@Service
public class ManageServiceImpl extends ServiceImpl<ManageMapper, Manage>
    implements ManageService
{
    @Resource
    private ManageMapper manageMapper;
    @Resource
    TroubleService troubleService;

    @Override
    public Page<Manage> getManagePageN(int page, int pageSize, LocalDate time)
    {
        pageSize = manageMapper.getMealPageCountN(time);
        page = 0;
        Page<Manage> pageInfo = new Page<>(page, pageSize);
        List<Manage> records =  manageMapper.getManagePageN(page, pageSize, time);
        pageInfo.setRecords(records);
        pageInfo.setTotal(pageSize);
        return pageInfo;
    }

    @Override
    public Page<Manage> getManagePageY(int page, int pageSize, LocalDate time)
    {
        pageSize = manageMapper.getMealPageCountY(time);
        page = 0;
        Page<Manage> pageInfo = new Page<>(page, pageSize);
        List<Manage> records =  manageMapper.getManagePageY(page, pageSize, time);
        pageInfo.setRecords(records);
        pageInfo.setTotal(pageSize);
        return pageInfo;
    }

    @Override
    public Page<Manage> getManagePageRepair(int page, int pageSize, int id, int status)
    {
        Page<Manage> pageInfo = new Page<>(page, pageSize);
        List<Manage> records =  manageMapper.getManagePageRepair(page, pageSize, id, status);
        pageInfo.setRecords(records);
        pageInfo.setTotal(manageMapper.getMealPageCountRepair(id, status));
        return pageInfo;
    }

    @Override
    public void exportExcel(List<Integer> idList, HttpServletResponse response)
    {
        // 表头数据
        List<Object> head = Arrays.asList("姓名","电话","地区","地址"
                ,"上传时间","备注","故障单状态","返单备注");
        List<List<Object>> sheetDataList = new ArrayList<>();
        sheetDataList.add(head);
        String time = "";
        for(Integer id:idList){
            Trouble trouble = troubleService.getById(id);
            String key = trouble.getKey();
            Manage manage = getById(key);
            List<Object> list = new ArrayList<>();
            TroubleDto troubleDto = new TroubleDto();
            troubleDto.setTrouble(trouble);
            troubleDto.setStatus(manage.getStatus());
            troubleDto.setMana_remark(manage.getManaRemark());
            list.add(troubleDto);
            sheetDataList.add(list);
            time = trouble.getSubmitTime().toString();
        }
        String out = time + "故障排查表";
        // 导出数据
        ExcelUtils.export(response, out, sheetDataList);
    }


}




