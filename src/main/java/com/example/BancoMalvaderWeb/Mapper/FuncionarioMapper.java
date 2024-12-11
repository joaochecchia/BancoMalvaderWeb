package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.DTO.FuncionarioDTO;
import com.example.BancoMalvaderWeb.Model.FuncionarioModel;

public class FuncionarioMapper {

    public static FuncionarioDTO map(FuncionarioModel model) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setIdUsuario(model.getIdUsuario());
        dto.setNome(model.getNome());
        dto.setEmail(model.getEmail());
        dto.setCpf(model.getCpf());
        dto.setDataNascimento(model.getDataNascimento());
        dto.setTelefone(model.getTelefone());
        dto.setEndereco(model.getEndereco());
        dto.setDataCriacao(model.getDataCriacao());
        dto.setDataEdicao(model.getDataEdicao());
        dto.setCodigoFuncionario(model.getCodigoFuncionario());
        dto.setCargo(model.getCargo());
        return dto;
    }

    public static FuncionarioModel map(FuncionarioDTO dto) {
        FuncionarioModel model = new FuncionarioModel();
        model.setIdUsuario(dto.getIdUsuario());
        model.setNome(dto.getNome());
        model.setEmail(dto.getEmail());
        model.setCpf(dto.getCpf());
        model.setDataNascimento(dto.getDataNascimento());
        model.setTelefone(dto.getTelefone());
        model.setEndereco(dto.getEndereco());
        model.setDataCriacao(dto.getDataCriacao());
        model.setDataEdicao(dto.getDataEdicao());
        model.setCodigoFuncionario(dto.getCodigoFuncionario());
        model.setCargo(dto.getCargo());
        return model;
    }
}