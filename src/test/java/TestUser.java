import com.GroceryStore.model.Appraise;
import com.GroceryStore.model.Users;
import com.GroceryStore.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/21 
//Time: 20:21
//To change this template use File | Settings | File Templates.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestUser {
    @Autowired
    UserService userService;
    @Test
    public void testUser(){
//        userService.insertUser("lee","123","1");
//        userService.changeUser("1","lee","1234","2","15504475422");
//        userService.deleteUser("2");
//        List<Users> l=userService.selectAll();
//        userService.insertAppraise("卖家小哥哥很帅气呢","2");
//        List<Appraise> list=userService.selectAppraisesBySell("2");
//        System.out.println(list.get(0));
        List<Appraise> list=userService.selectAppraisesByBuy("9");
        System.out.println(list.get(0));
    }
}
