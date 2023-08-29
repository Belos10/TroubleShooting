package org.telecom;

import static org.junit.Assert.assertTrue;

import net.sf.jsqlparser.statement.select.First;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.telecom.controller.ManageController;
import org.telecom.controller.UserController;
import org.telecom.pojo.User;
import org.telecom.service.UserService;
import org.telecom.utils.FirstLetterUtils;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest {
    @Resource
    UserService userService;


    @Test
    public void test() {
        User user = new User();
        user.setAccount("sdq81234");
        user.setPassword("SDQ81234");
        System.out.println(userService.loginService(user));
    }
}
