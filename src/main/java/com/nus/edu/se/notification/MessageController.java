package com.nus.edu.se.notification;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("messages")
public class MessageController {

    private KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody MessageRequest request) {
        Message message = new Message(request, LocalDateTime.now());
        kafkaTemplate.send("groupFoodOrderPlatform", message);

        String response = String.format("Notification sent for User ID: %s, Order ID: %s, Status: %s",
                request.userId(), request.orderId(), request.status());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
