package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.DTO.ClienteDTO;
import com.example.BancoMalvaderWeb.Service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getClienteById(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.findClienteById(id);

        if(clienteDTO != null){
            return ResponseEntity.ok("Cliente com id: " + id + " encontrado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com id: " + id + " não encontrado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO novoCliente = clienteService.criarCliente(clienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cliente criado: " + novoCliente.toString());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        if(clienteService.findClienteById(id) != null){
            ClienteDTO novoCliente = clienteService.editCliente(id, clienteDTO);
            return ResponseEntity.ok("Cliente com id: " + id + " editado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com id: "+  id + " não está cadastrado!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable Long id){
        if(clienteService.findClienteById(id) != null){
            clienteService.deleteCliente(id);

            return ResponseEntity.ok("Cliente com id " + id + " deletado!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cliente com id " + id + " não encontrado.");
        }
    }
}
