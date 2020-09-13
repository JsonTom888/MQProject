package com.example.active;

import com.example.active.active.queue.QueueProducer;
import com.example.active.active.topic.TopicProducer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleActiveQueueMqTests {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void sendSimpleQueueMessage() throws InterruptedException {
        this.queueProducer.sendQueue("Test queue message");
        Thread.sleep(1000L);
        assertThat(this.outputCapture.toString().contains("Test queue")).isTrue();
    }

    @Test
    public void send100QueueMessage() throws InterruptedException {
        for (int i=0;i<10;i++){
            this.queueProducer.sendQueue("Test queue message"+i);
        }
        Thread.sleep(1000L);
    }

    @Test
    public void sendSimpleTopicMessage() throws InterruptedException {
        this.topicProducer.sendTopic("Test Topic message");
        Thread.sleep(1000L);
    }

    @Test
    public void sendSimple100TopicMessage() throws InterruptedException {
        for (int i=0;i<10;i++){
            this.topicProducer.sendTopic("Test Topic message"+i);
        }
        Thread.sleep(1000L);
    }
}