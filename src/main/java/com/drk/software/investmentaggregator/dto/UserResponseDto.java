package com.drk.software.investmentaggregator.dto;

import java.util.UUID;

public record UserResponseDto (UUID id ,String username, String email) {
}
