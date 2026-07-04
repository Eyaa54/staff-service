package com.hospital.staffservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// Ecoute les messages publies par le service de mon collegue.
@Component
public class ForumEventListener {

    @KafkaListener(topics = "forum.post.created", groupId = "my-service-group")
    public void onPostCreated(String message) {
        System.out.println("📩 Message recu depuis Kafka : " + message);
        // ici tu peux reagir au message si besoin
    }
}