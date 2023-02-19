package org.steri.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steri.Library.entity.User;

public interface NotificationService {
    void sendNotification(String message, User user);
}

