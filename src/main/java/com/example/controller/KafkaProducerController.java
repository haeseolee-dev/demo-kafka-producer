package com.example.controller;

import com.example.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaProducerController {

    private final KafkaProducerService kafkaProducerService;

    public KafkaProducerController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/publish")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        kafkaProducerService.sendMessage(topic, message);
        return "Message sent to topic: " + topic;
    }
}
