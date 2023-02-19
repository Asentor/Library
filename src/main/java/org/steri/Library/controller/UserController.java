package org.steri.Library.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.steri.Library.entity.Subscription;
import org.steri.Library.entity.User;
import org.steri.Library.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('MANAGER')")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}/subscription")
    @PreAuthorize("hasRole('CLIENT')")
    public Subscription getSubscription(@PathVariable Long id) {
        return userService.getSubscription(id);
    }
}