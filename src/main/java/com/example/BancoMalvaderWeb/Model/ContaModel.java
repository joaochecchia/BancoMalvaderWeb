package com.example.BancoMalvaderWeb.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "conta")
public class ContaModel {
    @Id
    @Column(name = "id_conta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConta;

    @Column(name = "numero_conta")
    private String numeroConta;

    private String agencia;

    private double saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_id_usuario", nullable = false)
    private ClienteModel cliente;
}

