package com.example.BancoMalvaderWeb.Repository;

import com.example.BancoMalvaderWeb.Model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
