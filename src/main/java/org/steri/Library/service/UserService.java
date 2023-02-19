package org.steri.Library.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.steri.Library.entity.Subscription;
import org.steri.Library.entity.User;

public interface UserService extends UserDetailsService {
    User createUser(User user);
    User findByUsername(String username);
    User findById(Long id);
    Subscription getSubscription(Long id);
    User getUserById(Long id);
    void deleteUser(Long id);
}