package com.example.BancoMalvaderWeb.Repository;

import com.example.BancoMalvaderWeb.Model.UserSecurityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserSecurityRepository extends JpaRepository<UserSecurityModel, Long> {
    UserDetails findByEmail(String email);
}
