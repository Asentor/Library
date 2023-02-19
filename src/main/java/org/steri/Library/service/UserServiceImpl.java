package org.steri.Library.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.steri.Library.entity.LibraryUser;
import org.steri.Library.entity.Subscription;
import org.steri.Library.exception.ResourceNotFoundException;
import org.steri.Library.repo.UserRepository;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public LibraryUser createUser(LibraryUser libraryUser) {
        return userRepository.save(libraryUser);
        }

    @Override
    public LibraryUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

    }
    @Override
    public Subscription getSubscription(Long id) {
        LibraryUser libraryUser = userRepository.findById(id).orElse(null);
        return libraryUser != null ? libraryUser.getSubscription() : null;
    }

    @Override
    public LibraryUser findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public LibraryUser findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElse(null);
    }
}