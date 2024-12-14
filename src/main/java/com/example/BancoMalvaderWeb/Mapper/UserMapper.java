package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.Model.UserModel;
import com.example.BancoMalvaderWeb.Response.UserRequest;
import com.example.BancoMalvaderWeb.Response.UserResponse;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserModel toUserModel(UserRequest Request){
        UserModel model = new UserModel();

        model.setEmail(Request.email());
        model.setPassword(Request.password());

        return model;
    }

    public static UserResponse toUserResponse(UserModel model){
        return new UserResponse(
                model.getId(),
                model.getEmail()
        );
    }

    public static UserRequest toUserRequest(UserModel model){
        return new UserRequest(
                model.getEmail(),
                model.getPassword()
        );
    }
}
