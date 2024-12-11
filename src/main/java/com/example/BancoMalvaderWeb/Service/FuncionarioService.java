package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.Repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
}
