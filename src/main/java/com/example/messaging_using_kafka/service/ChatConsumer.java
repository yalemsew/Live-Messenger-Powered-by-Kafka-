package com.example.messaging_using_kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatConsumer {

    @KafkaListener(topics = "chat_topic", groupId = "chat-group")
    public void listen(String message) {
           // Process the received message
        System.out.println("Received Message: " + message);
    }
}

