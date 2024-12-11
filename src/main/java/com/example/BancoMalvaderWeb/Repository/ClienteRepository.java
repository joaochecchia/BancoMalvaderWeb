package com.example.BancoMalvaderWeb.Repository;

import com.example.BancoMalvaderWeb.Model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
