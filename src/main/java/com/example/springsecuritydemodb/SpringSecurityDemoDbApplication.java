package com.example.springsecuritydemodb;

import com.example.springsecuritydemodb.constants.Constants;
import com.example.springsecuritydemodb.models.DemoUser;
import com.example.springsecuritydemodb.repositories.DemoUserRepository;
import com.example.springsecuritydemodb.services.DemoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoDbApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityDemoDbApplication.class, args);
    }

    @Autowired
    private DemoUserRepository demoUserRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        DemoUser demoUser = DemoUser.builder()
                .username("mani@geeksforgeeks.org")
                .password(passwordEncoder.encode("mani123"))
                .authorities(Constants.DOCTOR_DETAILS_AUTHORITY + Constants.DELIMITER + Constants.DEO_DETAILS_AUTHORITY)
                .build();

        demoUserRepository.save(demoUser);

        DemoUser demoUser1 = DemoUser.builder()
                .username("vaishu@geeksforgeeks.org")
                .password(passwordEncoder.encode("vaishu123"))
                .authorities(Constants.CEO_DETAILS_AUTHORITY)
                .build();

        demoUserRepository.save(demoUser1);
    }
}
