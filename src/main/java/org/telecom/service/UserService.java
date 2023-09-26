package org.telecom.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.telecom.common.R;
import org.telecom.pojo.User;


public interface UserService extends IService<User> {
    R<User> loginService(User user);
    R<String> editUser(User user, String newPwd);
    R<String> addPerson(User user);
    Page<User> getUserPage(int page, int pageSize);
}
