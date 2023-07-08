package com.example.springsecuritydemodb.services;

import com.example.springsecuritydemodb.repositories.DemoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DemoUserService implements UserDetailsService {

    @Autowired
    DemoUserRepository demoUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return demoUserRepository.findByusername(username);
    }
}
