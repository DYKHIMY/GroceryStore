import com.GroceryStore.model.Goods;
import com.GroceryStore.service.StoreService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/13 
//Time: 21:25
//To change this template use File | Settings | File Templates.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:applicationContext.xml")
public class TestStore {
    @Autowired
    StoreService storeService;
    @org.junit.Test
    public void testgood(){
        Goods goods=new Goods();
//        int s=storeService.selectStock("1");
//        System.out.println(s);

//        storeService.deleteGood("3");

//        storeService.changeGoodStock("2",2);

//        int i=storeService.addGood("二手联想笔记本电脑",2,"两年半",null,3000,1,1);
//        System.out.println(i);

//        Goods goods1=storeService.selectGood("1");
//        System.out.println(goods1.getGoodIntro());

//        List<Goods> l=storeService.selectAllGoods();
//        System.out.println(l.get(1).getGoodIntro());

        int i=storeService.changeGoodByStateSell("2",1,"2");
        System.out.println(i);

    }
}
