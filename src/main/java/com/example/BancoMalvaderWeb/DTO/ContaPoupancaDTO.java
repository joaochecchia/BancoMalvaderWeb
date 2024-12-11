package com.example.BancoMalvaderWeb.DTO;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContaPoupancaDTO extends ContaDTO {
    private Double taxaRendimento;

}
