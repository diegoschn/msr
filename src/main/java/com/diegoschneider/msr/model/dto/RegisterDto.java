package com.diegoschneider.msr.model.dto;

import com.diegoschneider.msr.model.user.UserRole;

public record RegisterDto(String login, String password, UserRole role) {
}
