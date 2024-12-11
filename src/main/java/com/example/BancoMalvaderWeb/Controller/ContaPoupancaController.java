package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.DTO.ContaPoupancaDTO;
import com.example.BancoMalvaderWeb.Service.ContaPoupancaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta/poupanca")
@AllArgsConstructor
public class ContaPoupancaController {

    private final ContaPoupancaService contaPoupancaService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getContaPoupancaById(@PathVariable Long id){
        ContaPoupancaDTO contaPoupancaDTO = contaPoupancaService.findContaPoupancaById(id);

        if(contaPoupancaDTO != null){
            return ResponseEntity.ok("Conta poupança com id: " + id + " Encontrado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta poupança com id: " + id + " não encontrado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContaPoupanca(@RequestBody ContaPoupancaDTO contaPoupancaDTO){
        ContaPoupancaDTO novaConta = contaPoupancaService.criarContaPoupanca(contaPoupancaDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Conta poupança criada: " + novaConta.toString());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editContaPoupanca(@PathVariable Long id, @RequestBody ContaPoupancaDTO contaPoupancaDTO){
        if(contaPoupancaService.findContaPoupancaById(id) != null){
            ContaPoupancaDTO novoConta = contaPoupancaService.editContaPoupanca(id, contaPoupancaDTO);
            return ResponseEntity.ok("Conta poupança com id: " + id + " editado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta poupança com id: "+  id + " não está cadastrado!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContaPoupanca(@PathVariable Long id) {
        if (contaPoupancaService.findContaPoupancaById(id) != null) {
            contaPoupancaService.deleteContaPoupanca(id);

            return ResponseEntity.ok("Conta poupança com id " + id + " deletada!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Conta poupança com id " + id + " não encontrado.");
        }
    }
}
