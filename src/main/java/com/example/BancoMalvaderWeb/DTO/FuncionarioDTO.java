package com.example.BancoMalvaderWeb.DTO;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO extends UsuarioDTO {
    private String codigoFuncionario;
    private String cargo;
}
