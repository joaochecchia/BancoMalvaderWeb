package com.example.BancoMalvaderWeb.Config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.BancoMalvaderWeb.Model.UserModel;
import org.springframework.stereotype.Component;

import java.time.Instant;


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

}
