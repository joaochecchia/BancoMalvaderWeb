package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.DTO.FuncionarioDTO;
import com.example.BancoMalvaderWeb.Service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionario")
@RequiredArgsConstructor
public class FuncionarioController {

    public final FuncionarioService funcionarioService;

    @GetMapping
    public List<FuncionarioDTO> getFuncionarioById(@ID){

    }
}
