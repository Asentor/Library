package org.steri.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.steri.Library.entity.LibraryUser;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final EmailNotificationService emailNotificationService;

    @Autowired
    public NotificationServiceImpl(@Qualifier("javaMailEmailNotificationService") EmailNotificationService emailNotificationService) {
        this.emailNotificationService = emailNotificationService;
    }

    @Override
    public void sendNotification(String message, LibraryUser libraryUser) {
        emailNotificationService.sendNotification(libraryUser.getEmail(), "", message);
    }
}
