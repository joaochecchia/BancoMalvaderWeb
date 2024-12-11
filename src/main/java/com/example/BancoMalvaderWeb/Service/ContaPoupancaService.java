package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.DTO.ContaPoupancaDTO;
import com.example.BancoMalvaderWeb.Mapper.ContaPoupancaMapper;
import com.example.BancoMalvaderWeb.Model.ContaPoupancaModel;
import com.example.BancoMalvaderWeb.Repository.ContaPoupancaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContaPoupancaService {

    private final ContaPoupancaRepository contaPoupancaRepository;
    private final ContaPoupancaMapper contaPoupancaMapper;

    public ContaPoupancaDTO findContaPoupancaById(Long id){
        return  contaPoupancaRepository.findById(id)
                .map(contaPoupancaMapper::map)
                .orElse(null);
    }

    public ContaPoupancaDTO criarContaPoupanca(ContaPoupancaDTO contaPoupancaDTO){
        ContaPoupancaModel contaPoupancaModel = contaPoupancaMapper.map(contaPoupancaDTO);
        contaPoupancaModel = contaPoupancaRepository.save(contaPoupancaModel);

        return contaPoupancaMapper.map(contaPoupancaModel);
    }

    public ContaPoupancaDTO editContaPoupanca(Long id ,ContaPoupancaDTO contaPoupancaDTO){
        ContaPoupancaModel contaPoupancaModel = contaPoupancaMapper.map(contaPoupancaDTO);
        contaPoupancaModel.setIdConta(id);
        contaPoupancaModel = contaPoupancaRepository.save(contaPoupancaModel);

        return contaPoupancaMapper.map(contaPoupancaModel);
    }

    public void deleteContaPoupanca(Long id){
        contaPoupancaRepository.deleteById(id);
    }
}
