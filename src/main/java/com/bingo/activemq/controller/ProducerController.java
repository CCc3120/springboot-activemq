package com.bingo.activemq.controller;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	@Autowired
	private Topic topic;

	@RequestMapping("/queue/test")
	public String sendQueue(@RequestBody String str) {
		this.sendMessage(this.queue, str);
		return "success";
	}

	@RequestMapping("/topic/test")
	public String sendTopic(@RequestBody String str) {
		this.sendMessage(this.topic, str);
		return "success";
	}

	// 发送消息，destination是发送到的队列，message是待发送的消息
	private void sendMessage(Destination destination, final String message) {
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
}
