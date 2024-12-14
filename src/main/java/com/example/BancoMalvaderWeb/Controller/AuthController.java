package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.Config.TokenService;
import com.example.BancoMalvaderWeb.Mapper.UserMapper;
import com.example.BancoMalvaderWeb.Model.UserModel;
import com.example.BancoMalvaderWeb.Response.LoginResponse;
import com.example.BancoMalvaderWeb.Response.UserRequest;
import com.example.BancoMalvaderWeb.Response.UserResponse;
import com.example.BancoMalvaderWeb.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        UserModel savedUser = userService.saveUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserRequest userRequest){
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(userRequest.email(), userRequest.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        UserModel user =(UserModel) authentication.getPrincipal();
        String token = tokenService.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}
