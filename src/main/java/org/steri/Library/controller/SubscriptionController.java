package org.steri.Library.controller;

import org.springframework.web.bind.annotation.*;
import org.steri.Library.entity.Subscription;
import org.steri.Library.service.SubscriptionService;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @PostMapping("/{subscriptionId}/books/{bookId}")
    public void addBookToSubscription(@PathVariable Long subscriptionId, @PathVariable Long bookId) {
        subscriptionService.addBookToSubscription(subscriptionId, bookId);
    }

    @DeleteMapping("/{subscriptionId}/books/{bookId}")
    public void removeBookFromSubscription(@PathVariable Long subscriptionId, @PathVariable Long bookId) {
        subscriptionService.removeBookFromSubscription(subscriptionId, bookId);
    }
}
