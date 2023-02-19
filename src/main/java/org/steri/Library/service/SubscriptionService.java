package org.steri.Library.service;

import org.steri.Library.entity.Subscription;

import java.time.LocalDate;
import java.util.List;

public interface SubscriptionService {
    Subscription createSubscription(Subscription subscription);
    void addBookToSubscription(Long subscriptionId, Long bookId);
    void removeBookFromSubscription(Long subscriptionId, Long bookId);
    List<Subscription> findAllByEndDateBefore(LocalDate endDate);
    void sendNotificationToUsersWithExpiringSubscriptions(int daysBeforeExpiration);
}