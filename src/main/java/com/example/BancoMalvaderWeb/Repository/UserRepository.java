package com.example.BancoMalvaderWeb.Repository;

import com.example.BancoMalvaderWeb.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
