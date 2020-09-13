package com.example.active.active;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * 如果需要在同⼀项目中既支持队列模式也支持广播模式，可以通过 DefaultJmsListenerContainerFactory 创
 * 建⾃定义的 JmsListenerContainerFactory 实例，之后在 @JmsListener 注解中通过 containerFactory 属性引
 * ⽤用它。
 * 分别创建两个⾃定义的 JmsListenerContainerFactory 实例，通过 pubSubDomain 来控制是支持队列模式还
 * 是广播模式
 * @author tom
 * @version V1.0
 * @date 2020/9/13 17:30
 */
@Configuration
@EnableJms
public class ActiveMQConfig {
    @Bean("queueListenerFactory")
    public JmsListenerContainerFactory<?> queueListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    @Bean("topicListenerFactory")
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
