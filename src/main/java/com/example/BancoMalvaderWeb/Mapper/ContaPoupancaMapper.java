package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.Model.ContaPoupancaModel;
import com.example.BancoMalvaderWeb.DTO.ContaPoupancaDTO;
import org.springframework.stereotype.Component;

@Component
public class ContaPoupancaMapper {

    public static ContaPoupancaDTO map(ContaPoupancaModel contaPoupancaModel) {
        ContaPoupancaDTO contaPoupancaDTO = new ContaPoupancaDTO();
        contaPoupancaDTO.setIdConta(contaPoupancaModel.getIdConta());
        contaPoupancaDTO.setNumeroConta(contaPoupancaModel.getNumeroConta());
        contaPoupancaDTO.setAgencia(contaPoupancaModel.getAgencia());
        contaPoupancaDTO.setSaldo(contaPoupancaModel.getSaldo());
        contaPoupancaDTO.setCliente(contaPoupancaModel.getCliente());
        contaPoupancaDTO.setTaxaRendimento(contaPoupancaModel.getTaxaRendimento());

        return contaPoupancaDTO;
    }

    public static ContaPoupancaModel map(ContaPoupancaDTO contaPoupancaDTO) {
        ContaPoupancaModel contaPoupancaModel = new ContaPoupancaModel();
        contaPoupancaModel.setIdConta(contaPoupancaDTO.getIdConta());
        contaPoupancaModel.setNumeroConta(contaPoupancaDTO.getNumeroConta());
        contaPoupancaModel.setAgencia(contaPoupancaDTO.getAgencia());
        contaPoupancaModel.setSaldo(contaPoupancaDTO.getSaldo());
        contaPoupancaModel.setCliente(contaPoupancaDTO.getCliente());
        contaPoupancaModel.setTaxaRendimento(contaPoupancaDTO.getTaxaRendimento());

        return contaPoupancaModel;
    }
}