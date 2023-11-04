package com.example.springboot.dtos;

import com.example.springboot.enums.UserRole;

public record RegisterDTO (String login, String password, UserRole role){
}
