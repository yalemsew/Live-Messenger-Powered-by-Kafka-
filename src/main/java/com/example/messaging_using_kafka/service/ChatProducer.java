package com.example.messaging_using_kafka.service;

import com.example.messaging_using_kafka.model.ChatMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatProducer {

    private static final String TOPIC = "chat_topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper; // Provided by Spring Boot automatically

    public void sendMessage(ChatMessage chatMessage) {
        try {
            // Convert ChatMessage object to JSON string
            String message = objectMapper.writeValueAsString(chatMessage);
            kafkaTemplate.send(TOPIC, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
