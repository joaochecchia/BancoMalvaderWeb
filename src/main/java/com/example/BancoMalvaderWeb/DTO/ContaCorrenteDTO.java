package com.example.BancoMalvaderWeb.DTO;

import lombok.*;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrenteDTO extends ContaDTO {
    private double limite;
    private LocalDate dataVencimento;
}
