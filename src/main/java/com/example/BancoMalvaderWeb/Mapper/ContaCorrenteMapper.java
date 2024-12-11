package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.DTO.ContaCorrenteDTO;
import com.example.BancoMalvaderWeb.DTO.ContaDTO;
import com.example.BancoMalvaderWeb.Model.ContaCorrenteModel;
import com.example.BancoMalvaderWeb.Model.ContaModel;

public class ContaCorrenteMapper {
   public static ContaCorrenteDTO map(ContaCorrenteModel contaModel) {
        ContaCorrenteDTO DTO = new ContaCorrenteDTO();
        DTO.setIdConta(contaModel.getIdConta());
        DTO.setNumeroConta(contaModel.getNumeroConta());
        DTO.setAgencia(contaModel.getAgencia());
        DTO.setSaldo(contaModel.getSaldo());
        DTO.setCliente(contaModel.getCliente());

        return DTO;
    }

    public static ContaCorrenteModel map(ContaCorrenteDTO contaDTO) {
        ContaModel contaModel = new ContaModel();
        contaModel.setIdConta(contaDTO.getIdConta());
        contaModel.setNumeroConta(contaDTO.getNumeroConta());
        contaModel.setAgencia(contaDTO.getAgencia());
        contaModel.setSaldo(contaDTO.getSaldo());
        contaModel.setCliente(contaDTO.getCliente());

        return new ContaCorrenteModel();
    }
}
