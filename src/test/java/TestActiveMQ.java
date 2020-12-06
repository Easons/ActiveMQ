import com.pangpan.activemq.MainApp_Produce;
import com.pangpan.activemq.springboot.SpringBootMQ_Produce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = MainApp_Produce.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestActiveMQ {

    @Resource
    private SpringBootMQ_Produce springBootMQ_produce;

//    @Test
//    public  void tendSend(){
//        springBootMQ_produce.produceMsgScheduled();
//    }


}
