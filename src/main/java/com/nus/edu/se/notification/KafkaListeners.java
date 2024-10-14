package com.nus.edu.se.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
            topics = "groupFoodOrderPlatform",
            groupId = "groupId"
    )
    void listener(Message data) {
        System.out.println("Listener received:" + data);
    }
}
