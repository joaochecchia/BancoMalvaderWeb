package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.DTO.EnderecoDTO;
import com.example.BancoMalvaderWeb.Mapper.EnderecoMapper;
import com.example.BancoMalvaderWeb.Model.EnderecoModel;
import com.example.BancoMalvaderWeb.Repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnderecoService {

    EnderecoRepository enderecoRepository;
    EnderecoMapper enderecoMapper;

    public EnderecoDTO findEnderecoById(Long id){
        return  enderecoRepository.findById(id)
                .map(enderecoMapper::map)
                .orElse(null);
    }

    public EnderecoDTO criarEndereco(EnderecoDTO enderecoDTO){
        EnderecoModel enderecoModel = enderecoMapper.map(enderecoDTO);
        enderecoModel = enderecoRepository.save(enderecoModel);

        return enderecoMapper.map(enderecoModel);
    }

    public EnderecoDTO editEndereco(Long id ,EnderecoDTO enderecoDTO){
        EnderecoModel enderecoModel = enderecoMapper.map(enderecoDTO);
        enderecoModel.setIdEndereco(id);
        enderecoModel = enderecoRepository.save(enderecoModel);

        return enderecoMapper.map(enderecoModel);
    }

    public void deleteEndereco(Long id){
        enderecoRepository.deleteById(id);
    }
}
