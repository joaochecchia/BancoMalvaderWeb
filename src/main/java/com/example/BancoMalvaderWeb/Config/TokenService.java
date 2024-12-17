package com.example.BancoMalvaderWeb.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.BancoMalvaderWeb.Model.UserModel;
import com.example.BancoMalvaderWeb.Response.JWTUserResponse;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Optional;


@Component
public class TokenService {

    public String generateToken(UserModel user){
        Algorithm algorithm = Algorithm.HMAC256("palavra-secreta");

        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API-Banco")
                .sign(algorithm);
    }

    public Optional<JWTUserResponse> validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("palavra-secreta");

            DecodedJWT decode = JWT.require(algorithm)
                    .build()
                    .verify(token);

            return Optional.of(JWTUserResponse.builder()
                    .email(decode.getSubject())
                    .id(decode.getClaim("id").asLong())
                    .build());

        } catch (JWTVerificationException ex) {
            return Optional.empty();
        }
    }
}
