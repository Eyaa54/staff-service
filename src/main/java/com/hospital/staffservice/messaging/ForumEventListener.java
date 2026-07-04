package com.hospital.staffservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ForumEventListener {

    @KafkaListener(topics = "forum.post.created", groupId = "my-service-group")
    public void onPostCreated(String message) {
        System.out.println("New post event: " + message);
        // ici tu peux reagir au message recu
    }
}