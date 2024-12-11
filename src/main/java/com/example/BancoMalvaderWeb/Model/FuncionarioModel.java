package com.example.BancoMalvaderWeb.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "funcionario")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioModel extends UsuarioModel {
    @Column(name = "codigo_funcionario", length = 20)
    private String codigoFuncionario;

    @Column(length = 50)
    private String cargo;
}
