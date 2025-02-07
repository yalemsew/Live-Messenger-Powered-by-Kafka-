package com.example.messaging_using_kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatProducer {

    private static final String TOPIC = "chat_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        // Optionally, you can specify a key. Here, we use null.
        kafkaTemplate.send(TOPIC, message);
    }
}

