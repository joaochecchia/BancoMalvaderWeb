package com.example.BancoMalvaderWeb.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "conta_corrente")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContaCorrenteModel extends ContaModel {
    private double limite;

    @Column(name = "data_vencimento")
    private LocalDate dataVencimento;
}
