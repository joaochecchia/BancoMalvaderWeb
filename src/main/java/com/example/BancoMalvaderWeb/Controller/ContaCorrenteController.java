package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.DTO.ContaCorrenteDTO;
import com.example.BancoMalvaderWeb.Service.ContaCorrenteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta/corrente")
@AllArgsConstructor
public class ContaCorrenteController {

    private final ContaCorrenteService contaCorrenteService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getContaCorrenteById(@PathVariable Long id){
        ContaCorrenteDTO contaCorrenteDTO = contaCorrenteService.findContaCorrenteById(id);

        if(contaCorrenteDTO != null){
            return ResponseEntity.ok("Conta corrente com id: " + id + " Encontrado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta corrente com id: " + id + " não encontrado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContaCorrente(@RequestBody ContaCorrenteDTO ContaCorrenteDTO){
        ContaCorrenteDTO novaConta = contaCorrenteService.criarContaCorrente(ContaCorrenteDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Conta corrente criada: " + novaConta.toString());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editContaCorrente(@PathVariable Long id, @RequestBody ContaCorrenteDTO contaCorrenteDTO){
        if(contaCorrenteService.findContaCorrenteById(id) != null){
            ContaCorrenteDTO novoConta = contaCorrenteService.editContaCorrente(id, contaCorrenteDTO);
            return ResponseEntity.ok("Conta corrente com id: " + id + " editado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta corrente com id: "+  id + " não está cadastrado!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContaCorrente(@PathVariable Long id){
        if(contaCorrenteService.findContaCorrenteById(id) != null){
            contaCorrenteService.deleteContaCorrente(id);

            return ResponseEntity.ok("Conta corrente com id " + id + " deletada!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta corrente com id " + id + " não encontrado.");
        }
    }
}
