package org.steri.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.steri.Library.entity.LibraryUser;
import org.steri.Library.entity.Subscription;
import org.steri.Library.service.NotificationService;
import org.steri.Library.service.SubscriptionService;
import org.steri.Library.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/notifications")
@PreAuthorize("hasRole('MANAGER')")
public class NotificationController {

    private SubscriptionService subscriptionService;
    private UserService userService;
    private NotificationService notificationService;

    @Autowired
    public NotificationController(SubscriptionService subscriptionService, UserService userService, NotificationService notificationService) {
        this.subscriptionService = subscriptionService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public void sendNotifications() {

        List<Subscription> subscriptions = subscriptionService.findAllByEndDateBefore(LocalDate.now().plusDays(7));

        for (Subscription subscription : subscriptions) {
            LibraryUser libraryUser = userService.findById(subscription.getLibraryUser().getId());
            String message = "Your subscription will expire in 7 days.";
            notificationService.sendNotification(message, libraryUser);
        }
    }
}