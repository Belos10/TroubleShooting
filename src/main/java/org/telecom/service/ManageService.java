package org.telecom.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.telecom.pojo.Manage;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

/**
* @author Xu
* @description 针对表【manage】的数据库操作Service
* @createDate 2023-08-23 10:46:33
*/
public interface ManageService extends IService<Manage> {

    Page<Manage> getManagePageN(int page, int pageSize, LocalDate time);
    Page<Manage> getManagePageY(int page, int pageSize, LocalDate time);
    Page<Manage> getManagePageRepair(int page, int pageSize, int id, int status);
    void exportExcel(List<Integer> list, HttpServletResponse response);
}
