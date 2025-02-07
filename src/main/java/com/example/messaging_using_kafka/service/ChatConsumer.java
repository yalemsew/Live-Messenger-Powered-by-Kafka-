package com.example.messaging_using_kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatConsumer {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "chat_topic", groupId = "chat-group")
    public void listen(String message) {
        // When a Kafka message is received, broadcast it to WebSocket subscribers.
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
