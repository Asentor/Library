package org.steri.Library.service;

import org.steri.Library.entity.LibraryUser;

public interface NotificationService {
    void sendNotification(String message, LibraryUser libraryUser);
}

