package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.DTO.FuncionarioDTO;
import com.example.BancoMalvaderWeb.Service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
@AllArgsConstructor
public class FuncionarioController {

    public final FuncionarioService funcionarioService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getFuncionarioById(@PathVariable Long id){
        FuncionarioDTO funcionarioDTO = funcionarioService.findFuncionarioById(id);

        if(funcionarioDTO != null){
            return ResponseEntity.ok("Funcionário com id: " + id + " Encontrado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário com id: " + id + " não encontrado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFuncionario(@RequestBody FuncionarioDTO funcionarioDTO){
        FuncionarioDTO novoFuncionario = funcionarioService.createFuncionario(funcionarioDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Usuario Criado: " + funcionarioDTO.toString());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editFuncionario(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO){
        if(funcionarioService.findFuncionarioById(id) != null){
            FuncionarioDTO novoFuncionario = funcionarioService.editFuncionario(id, funcionarioDTO);
            return ResponseEntity.ok("Usuário com id: " + id + " editado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Usuário com id: "+  id + " não está cadastrado!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id){
        if(funcionarioService.findFuncionarioById(id) != null){
            funcionarioService.deleteFuncionario(id);

            return ResponseEntity.ok("Funcioário com id " + id + " não está cadastrado!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário com id " + id + " não encontrado.");
        }
    }
}
