package org.steri.Library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.steri.Library.entity.LibraryUser;
import org.steri.Library.repo.UserRepository;

import java.util.stream.Collectors;

@Service
public class LibraryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LibraryUser libraryUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                libraryUser.getUsername(),
                libraryUser.getPassword(),
                libraryUser.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList())
        );
    }
}