package abc.wuyan.test;

import abc.wuyan.model.User;
import abc.wuyan.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestUser {
    @Autowired
    UserService userService;

    @Test
    public void list() {
        List<User> UserList = userService.findAll();
        System.out.println(UserList.toString());
    }
}
