package com.example.BancoMalvaderWeb.DTO;

import com.example.BancoMalvaderWeb.Model.ClienteModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {
    private Double idConta;
    private String numeroConta;
    private String agencia;
    private double saldo;
    private ClienteModel cliente;

}
