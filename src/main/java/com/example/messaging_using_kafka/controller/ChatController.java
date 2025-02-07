package com.example.messaging_using_kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.messaging_using_kafka.model.ChatMessage;
import com.example.messaging_using_kafka.service.ChatProducer;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatProducer chatProducer;

    // Endpoint to receive a chat message from the client (React)
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody ChatMessage chatMessage) {
        // Set the current timestamp before sending
        chatMessage.setTimestamp(LocalDateTime.now());
        chatProducer.sendMessage(chatMessage);
        return ResponseEntity.ok("Message sent");
    }
}


