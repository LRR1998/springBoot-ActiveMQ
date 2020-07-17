package com.yaspeed.demo716.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ProviderController {
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @RequestMapping("queue")
    public void send(String name){
        jmsMessagingTemplate.convertAndSend(queue,name);
    }
    @RequestMapping("topic")
    public void topic(String name){
        jmsMessagingTemplate.convertAndSend(topic,name);
    }
}
