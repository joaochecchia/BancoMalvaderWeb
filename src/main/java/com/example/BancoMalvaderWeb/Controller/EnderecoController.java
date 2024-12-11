package com.example.BancoMalvaderWeb.Controller;

import com.example.BancoMalvaderWeb.DTO.EnderecoDTO;
import com.example.BancoMalvaderWeb.Service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@AllArgsConstructor
public class EnderecoController {

    EnderecoService enderecoService;

    @GetMapping("/getById/{id}")
    public ResponseEntity<String> getEnderecoById(@PathVariable Long id){
        EnderecoDTO enderecoDTO = enderecoService.findEnderecoById(id);

        if(enderecoDTO != null){
            return ResponseEntity.ok("Endereco com id: " + id + " Encontrado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Endereco com id: " + id + " não encontrado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEndereco(@RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO novoEndereco = enderecoService.criarEndereco(enderecoDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Endereco criado: " + enderecoDTO.toString());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editEndereco(@PathVariable Long id, @RequestBody EnderecoDTO enderecoDTO){
        if(enderecoService.findEnderecoById(id) != null){
            EnderecoDTO novoEndereco = enderecoService.editEndereco(id, enderecoDTO);
            return ResponseEntity.ok("Endereco com id: " + id + " editado com sucesso!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Endereco com id: "+  id + " não está cadastrado!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEndereco(@PathVariable Long id){
        if(enderecoService.findEnderecoById(id) != null){
            enderecoService.deleteEndereco(id);

            return ResponseEntity.ok("Endereco com id " + id + " não está cadastrado!");
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Endereco com id " + id + " não encontrado.");
        }
    }
}
