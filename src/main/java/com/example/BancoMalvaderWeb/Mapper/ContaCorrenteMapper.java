package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.DTO.ContaCorrenteDTO;
import com.example.BancoMalvaderWeb.Model.ContaCorrenteModel;
import org.springframework.stereotype.Component;

@Component
public class ContaCorrenteMapper {
   public ContaCorrenteDTO map(ContaCorrenteModel contaModel) {
        ContaCorrenteDTO DTO = new ContaCorrenteDTO();
        DTO.setIdConta(contaModel.getIdConta());
        DTO.setNumeroConta(contaModel.getNumeroConta());
        DTO.setAgencia(contaModel.getAgencia());
        DTO.setSaldo(contaModel.getSaldo());
        DTO.setCliente(contaModel.getCliente());
        DTO.setLimite(contaModel.getLimite());
        DTO.setDataVencimento(contaModel.getDataVencimento());

        return DTO;
    }

    public ContaCorrenteModel map(ContaCorrenteDTO contaDTO) {
        ContaCorrenteModel model = new ContaCorrenteModel();
        model.setIdConta(contaDTO.getIdConta());
        model.setNumeroConta(contaDTO.getNumeroConta());
        model.setAgencia(contaDTO.getAgencia());
        model.setSaldo(contaDTO.getSaldo());
        model.setCliente(contaDTO.getCliente());
        model.setLimite(contaDTO.getLimite());
        model.setDataVencimento(contaDTO.getDataVencimento());

        return model;
    }
}
