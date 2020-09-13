package com.example.rabbitmq;

import com.example.rabbitmq.exchange.ExchangeSender;
import com.example.rabbitmq.fanout.FanoutRabbitSender;
import com.example.rabbitmq.hellotest.HelloSender;
import com.example.rabbitmq.manytomany.ManySender1;
import com.example.rabbitmq.manytomany.ManySender2;
import com.example.rabbitmq.model.User;
import com.example.rabbitmq.onetomany.TomSender;
import com.example.rabbitmq.sendObject.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private TomSender tomSender;
    @Autowired
    private ManySender1 manySender1;
    @Autowired
    private ManySender2 manySender2;
    @Autowired
    private ObjectSender objectSender;
    @Autowired
    private ExchangeSender exchangeSender;
    @Autowired
    private FanoutRabbitSender fanoutRabbitSender;

    /**
     * 测试每种场景，要把另外两种场景配置的consumer注释掉
     *
     * @throws Exception
     */
    @Test
    public void hello() throws Exception {
        helloSender.send();
        Thread.sleep(1000l);
    }

    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<10;i++){
            tomSender.send(i);
        }
        Thread.sleep(10000l);
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i=0;i<20;i++){
            manySender1.send(i);
            manySender2.send(i);
        }
        Thread.sleep(10000l);
    }

    @Test
    public void sendOject() throws Exception {
        User user=new User();
        user.setName("tom");
        user.setPass("123456");
        objectSender.send(user);
        Thread.sleep(1000l);
    }

    @Test
    public void topic1() throws Exception {
        exchangeSender.send1();
        Thread.sleep(3000l);
    }

    @Test
    public void topic2() throws Exception {
        exchangeSender.send2();
        Thread.sleep(1000l);
    }

    @Test
    public void fanoutSender() throws Exception {
        fanoutRabbitSender.send();
        Thread.sleep(1000l);
    }

}
