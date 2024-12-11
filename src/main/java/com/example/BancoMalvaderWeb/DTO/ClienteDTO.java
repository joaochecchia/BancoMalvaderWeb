package com.example.BancoMalvaderWeb.DTO;

import com.example.BancoMalvaderWeb.Model.ContaModel;
import lombok.*;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO extends UsuarioDTO {
    private List<ContaModel> contas;
}
