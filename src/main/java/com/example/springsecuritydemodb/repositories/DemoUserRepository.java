package com.example.springsecuritydemodb.repositories;

import com.example.springsecuritydemodb.models.DemoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoUserRepository extends JpaRepository<DemoUser,Integer> {

    DemoUser findByusername(String username);
}
