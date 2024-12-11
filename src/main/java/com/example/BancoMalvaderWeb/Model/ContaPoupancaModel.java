package com.example.BancoMalvaderWeb.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "conta_poupanca")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContaPoupancaModel extends ContaModel {
    @Column(name = "taxa_rendimento")
    private Double taxaRendimento;

}
