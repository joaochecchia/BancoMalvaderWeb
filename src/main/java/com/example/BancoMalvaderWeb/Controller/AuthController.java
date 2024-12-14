package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.Mapper.UserMapper;
import com.example.BancoMalvaderWeb.Model.UserModel;
import com.example.BancoMalvaderWeb.Response.UserRequest;
import com.example.BancoMalvaderWeb.Response.UserResponse;
import com.example.BancoMalvaderWeb.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest userRequest){
        UserModel savedUser = userService.saveUser(userRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserMapper.toUserResponse(savedUser));
    }
}
