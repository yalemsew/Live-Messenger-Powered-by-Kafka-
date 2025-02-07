package com.example.messaging_using_kafka.controller;

import com.example.messaging_using_kafka.service.ChatProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatProducer chatProducer;

    // Endpoint to send a chat message
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        chatProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent: " + message);
    }
}

