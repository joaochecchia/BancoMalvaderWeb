package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.DTO.FuncionarioDTO;
import com.example.BancoMalvaderWeb.Mapper.FuncionarioMapper;
import com.example.BancoMalvaderWeb.Model.FuncionarioModel;
import com.example.BancoMalvaderWeb.Repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper funcionarioMapper;

    public FuncionarioDTO findFuncionarioById(Long id){
        return funcionarioRepository.findById(id)
                .map(funcionarioMapper::map)
                .orElse(null);
    }

    public FuncionarioDTO createFuncionario(FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionarioModel = funcionarioMapper.map(funcionarioDTO);
        funcionarioModel = funcionarioRepository.save(funcionarioModel);

        return funcionarioMapper.map(funcionarioModel);
    }

    public FuncionarioDTO editFuncionario(Long id ,FuncionarioDTO funcionarioDTO){
        FuncionarioModel funcionarioModel = funcionarioMapper.map(funcionarioDTO);
        funcionarioModel.setIdUsuario(id);
        funcionarioModel = funcionarioRepository.save(funcionarioModel);

        return funcionarioMapper.map(funcionarioModel);
    }

    public void deleteFuncionario(Long id){
        funcionarioRepository.deleteById(id);
    }
}
