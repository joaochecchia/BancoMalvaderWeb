package com.example.BancoMalvaderWeb.Response;

import lombok.Builder;

@Builder
public record UserResponse(Long id, String email) {
}
