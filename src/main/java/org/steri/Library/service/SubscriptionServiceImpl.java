package org.steri.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steri.Library.entity.Book;
import org.steri.Library.entity.Subscription;
import org.steri.Library.entity.User;
import org.steri.Library.exception.ResourceNotFoundException;
import org.steri.Library.repo.BookRepository;
import org.steri.Library.repo.SubscriptionRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    private BookRepository bookRepository;
    private UserServiceImpl userServiceImpl;
    private NotificationService notificationService;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository, BookRepository bookRepository, UserServiceImpl userServiceImpl, NotificationService notificationService) {
        this.subscriptionRepository = subscriptionRepository;
        this.bookRepository = bookRepository;
        this.userServiceImpl = userServiceImpl;
        this.notificationService = notificationService;
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {
        User user = userServiceImpl.findById(subscription.getUser().getId()); // fetch user from database
        subscription.setUser(user);
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void addBookToSubscription(Long subscriptionId, Long bookId) {
        Subscription subscription = getSubscriptionById(subscriptionId); // fetch subscription from database
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        subscription.getLoans().add(book);
        book.setSubscription(subscription);
        subscriptionRepository.save(subscription);
    }

    @Override
    public void removeBookFromSubscription(Long subscriptionId, Long bookId) {
        Subscription subscription = getSubscriptionById(subscriptionId); // fetch subscription from database
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        subscription.getLoans().remove(book);
        book.setSubscription(null);
        subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> findAllByEndDateBefore(LocalDate expirationDate) {
        return subscriptionRepository.findAllByEndDateBefore(expirationDate);
    }

    @Override
    public void sendNotificationToUsersWithExpiringSubscriptions(int daysBeforeExpiration) {
        LocalDate expirationDate = LocalDate.now().plusDays(daysBeforeExpiration);
        List<Subscription> subscriptions = subscriptionRepository.findAllByEndDateBefore(expirationDate);

        for (Subscription subscription : subscriptions) {
            User user = subscription.getUser();
            String message = "Your subscription with id " + subscription.getId() + " is expiring soon!";
            notificationService.sendNotification(message, user);
        }
    }

    private Subscription getSubscriptionById(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId).orElseThrow(() -> new ResourceNotFoundException("Subscription not found"));
    }
}
