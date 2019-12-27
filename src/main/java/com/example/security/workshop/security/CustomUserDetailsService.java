package com.example.security.workshop.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final Map<String, UserDetails> userDetailsMap = new HashMap<>();

    public CustomUserDetailsService() {
        User guest = new User(
                "user",
                "{noop}password",
                Collections.singletonList(new SimpleGrantedAuthority("guest"))
        );

        String encodePassword = "{bcrypt}" + bCryptPasswordEncoder.encode("password");
        User admin = new User(
                "admin",
                encodePassword,
                Collections.singletonList(new SimpleGrantedAuthority("admin"))
        );

        userDetailsMap.put(guest.getUsername(), guest);
        userDetailsMap.put(admin.getUsername(), admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*TODO 假装 user数据是从数据库find 出来的*/
        UserDetails userDetails = userDetailsMap.get(username);

        if (userDetails == null) {
            throw new UsernameNotFoundException(username);
        }

        return userDetails;
    }
}
