package com.test.task.dto.user;

public record UserLoginResponseDto(String token,
                                   String id,
                                   String email) {
}
