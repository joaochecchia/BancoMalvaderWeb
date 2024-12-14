package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.Model.ClienteModel;
import com.example.BancoMalvaderWeb.DTO.ClienteDTO;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDTO map(ClienteModel model) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdUsuario(model.getIdUsuario());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setCpf(model.getCpf());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setTelefone(model.getTelefone());
        dto.setEndereco(model.getEndereco());
        dto.setDataCriacao(model.getDataCriacao());
        dto.setDataEdicao(model.getDataEdicao());
        dto.setContas(model.getContas());
        return dto;
    }

    public ClienteModel map(ClienteDTO dto) {
        ClienteModel model = new ClienteModel();
        model.setIdUsuario(dto.getIdUsuario());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setCpf(dto.getCpf());
        model.setDataNascimento(dto.getDataNascimento());
        model.setTelefone(dto.getTelefone());
        model.setEndereco(dto.getEndereco());
        model.setDataCriacao(dto.getDataCriacao());
        model.setDataEdicao(dto.getDataEdicao());
        model.setContas(dto.getContas());
        return model;
    }
}