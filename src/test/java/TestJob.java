import com.GroceryStore.model.Jobs;
import com.GroceryStore.service.JobService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

// Created by IntelliJ IDEA.
//User: lhz
//Date: 2019/5/14 
//Time: 19:53
//To change this template use File | Settings | File Templates.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class TestJob {
//    @Autowired
//    JobMapper jobMapper;
    @Autowired
    JobService jobService;
    @Test
    public void testJob(){
//       jobService.updateJob("1","初中数学家教","1","周六日一共三小时","1","最好是大一的男生","1","70","1","0","0");
//        jobService.addJob("东北师大一食堂二楼奶茶店打杂","2","下午12：00-3：00","1",
//                "工资按天结算，一天50","2","50","0","0","0");
//        List<Jobs> l=jobService.findByName("家教");
//        System.out.println(l.get(0).getJobName()

//       jobService.addResume("1","1","男，大一化学学院，高考Ⅱ卷625，数学单科145，周六日全天有时间","lee");
//        jobService.deleteJob("8");
//        List<Jobs> l=jobService.listJob();
//        System.out.println(l.get(0).getJobName());
     //   jobService.updateJobByState("2","1");

        jobService.selectJobByReq("1","2","3","1");
        System.out.println(1);
    }
}
