package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.Mapper.UserMapper;
import com.example.BancoMalvaderWeb.Model.UserModel;
import com.example.BancoMalvaderWeb.Repository.UserRepository;
import com.example.BancoMalvaderWeb.Response.UserRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserModel saveUser(UserRequest userRequest){
        if(userRepository.findUserModelByEmail(userRequest.email()).isPresent()){
            return null;
        }

        UserModel newUser = UserMapper.toUserModel(userRequest);

        String password = passwordEncoder.encode(userRequest.password());
        newUser.setPassword(password);

        return userRepository.save(newUser);
    }
}
