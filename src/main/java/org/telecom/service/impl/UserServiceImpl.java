package org.telecom.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.telecom.common.R;
import org.telecom.mapper.UserMapper;
import org.telecom.pojo.Manage;
import org.telecom.pojo.User;
import org.telecom.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.telecom.utils.FirstLetterUtils;
import org.telecom.utils.UUIDUtils;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService
{
    @Resource
    private UserMapper userMapper;

    @Override
    public R<User> loginService(User user)
    {
        // 将页面提交密码password进行md5加密
        String password = user.getPwd();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据页面提交账户account查询数据库
        String account = user.getAcct();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAcct, account).eq(User::getPwd, password);
        User emp = getOne(lambdaQueryWrapper);

        if (emp == null)
            return R.error("登录失败，用户名或密码错误");
        return R.success(emp);
    }

    @Override
    public R<String> editUser(User user, String newPwd)
    {
        if (newPwd == null || newPwd.isEmpty())
            return R.error("未输入新密码");
        //密码错误
        String pwd = DigestUtils.md5DigestAsHex(user.getPwd().getBytes());
        String account = user.getAcct();
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getAcct, account).eq(User::getPwd, pwd);
        User emp = getOne(lambdaQueryWrapper);
        if (emp == null)
            return R.error("账户或密码错误");
        newPwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        //密码重复
        if (emp.getPwd().equals(newPwd))
            return R.error("新密码不可与原密码重复");
        //成功
        emp.setPwd(newPwd);
        saveOrUpdate(emp);
        return R.success("修改成功");
    }

    @Override
    public R<String> addPerson(User user) {
        String name = user.getUserName();
        String phone = user.getPhone();
        String account = FirstLetterUtils.getFirstLetterOptimized(name) + phone.substring(phone.length()-5);
        user.setAcct(account);
//        String password = UUIDUtils.getUUIDTopEight();
//        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setPwd(DigestUtils.md5DigestAsHex(account.toLowerCase().getBytes()));
        saveOrUpdate(user);
        return R.success("上传成功");
    }

    @Override
    public Page<User> getUserPage(int page, int pageSize)
    {
        Page<User> pageInfo = new Page<>(page, pageSize);
        pageSize = userMapper.getUserPageCount();
        page = 0;
        List<User> records =  userMapper.getUserPage(page, pageSize);
        pageInfo.setRecords(records);
        pageInfo.setTotal(userMapper.getUserPageCount());
        return pageInfo;
    }

}




