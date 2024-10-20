package com.nus.edu.se.notification;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    private final SimpMessagingTemplate messagingTemplate;

    public KafkaListeners(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @KafkaListener(
            topics = "groupFoodOrderPlatform",
            groupId = "groupId",
            containerFactory = "factory"
    )
    void listener(Message data) {
        String userId = data.messageRequest().userId();
        messagingTemplate.convertAndSend("/topic/" + userId, data);
        System.out.println("Listener received and sent notification to user: " + userId);
    }
}
