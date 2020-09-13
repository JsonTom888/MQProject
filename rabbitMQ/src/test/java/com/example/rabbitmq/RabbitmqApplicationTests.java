package com.example.rabbitmq;

import com.example.rabbitmq.hellotest.HelloSender;
import com.example.rabbitmq.manytomany.ManySender1;
import com.example.rabbitmq.manytomany.ManySender2;
import com.example.rabbitmq.onetomany.TomSender;
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

}
