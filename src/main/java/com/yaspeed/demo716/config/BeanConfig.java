package com.yaspeed.demo716.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class BeanConfig {
    @Bean(name = "queue")
    public Queue queue(){
        return new ActiveMQQueue("ActiveMQQueue");
    }
    @Bean(name = "topic")
    public Topic topic(){
        return new ActiveMQTopic("ActiveMQTopic");
    }

    /**这里直接用读取配置的形式注入了connectionFactory的属性，还可以使用构造器来创建connectionFactory
        @Bean
        public ConnectionFactory connectionFactory(){
            return new ActiveMQConnectionFactory(user, password, brokerUrl);
        }
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.activemq")
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        return activeMQConnectionFactory;
    }
    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(){
        return new JmsMessagingTemplate(connectionFactory());
    }
}
