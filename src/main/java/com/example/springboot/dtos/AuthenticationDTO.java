package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;


import java.math.BigDecimal;

public record AuthenticationDTO(@NotBlank String login, @NotBlank String password) {
}
