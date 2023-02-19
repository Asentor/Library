package org.steri.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.steri.Library.entity.User;

public interface EmailNotificationService {
    void sendNotification(String recipient, String subject, String message);
}

