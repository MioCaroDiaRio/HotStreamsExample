package com.example.imagecompressor.service;

import com.example.imagecompressor.entity.Notification;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class NotificationService {
    private final WebClient webClient;

    public NotificationService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void sendNotification(Notification notification) {
        webClient.post()
                .uri("http://localhost:8082/notifications")
                .bodyValue(notification)
                .retrieve()
                .toBodilessEntity()
                .subscribe();
    }
}