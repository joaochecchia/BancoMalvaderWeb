package com.example.BancoMalvaderWeb.Repository;

import com.example.BancoMalvaderWeb.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserDetails> findUserModelByEmail(String email);
}
