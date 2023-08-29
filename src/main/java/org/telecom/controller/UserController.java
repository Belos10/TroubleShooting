package org.telecom.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.telecom.common.R;
import org.telecom.common.ThreadLocalUtil;
import org.telecom.pojo.User;
import org.telecom.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录界面
@RequestMapping("/user")
@Slf4j
@RestController
public class UserController
{
    @Resource
    private UserService userService;

    //登录管理员账户
    @PostMapping("/login")
    public R<User> loginApi(@RequestBody User user, HttpSession session, HttpServletResponse response) {
        R<User> r = userService.loginService(user);
        if (r.getCode() == 0) {
            return r;
        }
        session.setAttribute("loginUser", r.getData().getId());
        return r;
    }


    //登出
    @PostMapping("/loginout")
    public R<String> logout(HttpSession session)
    {
        session.removeAttribute("loginUser");
        ThreadLocalUtil.remove();
        return R.success("退出成功");
    }

    //修改密码
    @PostMapping("/changepwd")
    public R<String> changePassword(@RequestBody User user, @RequestHeader("newPwd") String newPwd)
    {
        return userService.editUser(user, newPwd);
    }

    //增加人员  初始密码与账号相同
    @PostMapping("/addPerson")
    public R<String> addPerson(@RequestBody User user) {
        return userService.addPerson(user);
    }

    //查看通讯录
    @GetMapping("/viewPerson")
    public R<Page<User>> viewPerson(int page, int pageSize, HttpSession session){
        int id = (int) session.getAttribute("loginUser");
        User user = userService.getById(id);
        int level = user.getLevel();
        return R.success(userService.getUserPage((page - 1) * pageSize, pageSize));
    }

}
