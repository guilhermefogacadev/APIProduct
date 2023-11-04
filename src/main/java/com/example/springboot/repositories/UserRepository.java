package com.example.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot.models.UserModel;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository  extends JpaRepository<UserModel, String> {
    UserDetails findByLogin(String Login);
}
