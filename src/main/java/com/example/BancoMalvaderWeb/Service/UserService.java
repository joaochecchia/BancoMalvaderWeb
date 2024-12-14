package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.Mapper.UserMapper;
import com.example.BancoMalvaderWeb.Model.UserModel;
import com.example.BancoMalvaderWeb.Repository.UserRepository;
import com.example.BancoMalvaderWeb.Response.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    public UserModel saveUser(UserRequest userRequest){
        UserModel newUser = UserMapper.toUserModel(userRequest);

        return userRepository.save(newUser);
    }
}
