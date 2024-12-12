package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.DTO.ClienteDTO;
import com.example.BancoMalvaderWeb.DTO.ContaCorrenteDTO;
import com.example.BancoMalvaderWeb.Mapper.ContaCorrenteMapper;
import com.example.BancoMalvaderWeb.Model.ContaCorrenteModel;
import com.example.BancoMalvaderWeb.Repository.ContaCorrenteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaCorrenteService {

    private final ContaCorrenteRepository contaCorrenteRepository;
    private final ContaCorrenteMapper contaCorrenteMapper;

    public ContaCorrenteDTO findContaCorrenteById(Long id){
        return  contaCorrenteRepository.findById(id)
                .map(contaCorrenteMapper::map)
                .orElse(null);
    }

    public ContaCorrenteDTO criarContaCorrente(ContaCorrenteDTO ContaCorrenteDTO){
        ContaCorrenteModel contaCorrenteModel = contaCorrenteMapper.map(ContaCorrenteDTO);
        contaCorrenteModel = contaCorrenteRepository.save(contaCorrenteModel);

        return contaCorrenteMapper.map(contaCorrenteModel);
    }

    public ContaCorrenteDTO editContaCorrente(Long id ,ContaCorrenteDTO contaCorrenteDTO){
        ContaCorrenteModel contaCorrenteModel = contaCorrenteMapper.map(contaCorrenteDTO);
        contaCorrenteModel.setIdConta(id);
        contaCorrenteModel = contaCorrenteRepository.save(contaCorrenteModel);

        return contaCorrenteMapper.map(contaCorrenteModel);
    }

    public void deleteContaCorrente(Long id){
        contaCorrenteRepository.deleteById(id);
    }
}
