package org.steri.Library.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.steri.Library.entity.LibraryUser;
import org.steri.Library.entity.Subscription;

public interface UserService extends UserDetailsService {
    LibraryUser createUser(LibraryUser libraryUser);
    LibraryUser findByUsername(String username);
    LibraryUser findById(Long id);
    Subscription getSubscription(Long id);
    LibraryUser getUserById(Long id);
    void deleteUser(Long id);
}