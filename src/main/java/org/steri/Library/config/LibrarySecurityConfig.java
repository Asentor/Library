package org.steri.Library.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.steri.Library.service.UserService;

@Configuration
@EnableWebSecurity
public class LibrarySecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public LibrarySecurityConfig(UserService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder(12));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/books/create", "/api/books/delete").hasRole("MANAGER")
                .antMatchers("/api/users/create", "/api/subscriptions/create", "/api/subscriptions/add_book", "/api/subscriptions/remove_book").hasRole("MANAGER")
                .antMatchers("/api/subscriptions/**").hasRole("CLIENT")
                .anyRequest().authenticated()
                .and().formLogin()
                .and().logout()
                .and().csrf().disable();
    }


}