package com.example.BancoMalvaderWeb.DTO;

import com.example.BancoMalvaderWeb.Model.UsuarioModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {
    private Long id;
    private String cep;
    private String cidade;
    private String bairro;
    private String local;
    private int numeroCasa;
    private UsuarioModel usuario;
}
