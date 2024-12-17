package com.example.BancoMalvaderWeb.Response;

import lombok.Builder;

@Builder
public record JWTUserResponse(Long id, String email){
}
