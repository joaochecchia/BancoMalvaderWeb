package com.example.BancoMalvaderWeb.DTO;

import com.example.BancoMalvaderWeb.Model.EnderecoModel;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class UsuarioDTO {
    private Long idUsuario;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private String telefone;
    private List<EnderecoModel> endereco;
    private LocalDate dataCriacao;
    private LocalDate dataEdicao;

}
