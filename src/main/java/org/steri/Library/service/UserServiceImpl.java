package org.steri.Library.service;

import lombok.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.steri.Library.dto.UserDto;
import org.steri.Library.entity.Role;
import org.steri.Library.entity.Subscription;
import org.steri.Library.entity.User;
import org.steri.Library.enums.RoleEnum;
import org.steri.Library.exception.ResourceNotFoundException;
import org.steri.Library.repo.RoleRepository;
import org.steri.Library.repo.SubscriptionRepository;
import org.steri.Library.repo.UserRepository;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
        }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

    }
    @Override
    public Subscription getSubscription(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user != null ? user.getSubscription() : null;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public User findById(Long id) {
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