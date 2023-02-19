package org.steri.Library.service;

public interface EmailNotificationService {
    void sendNotification(String recipient, String subject, String message);
}

