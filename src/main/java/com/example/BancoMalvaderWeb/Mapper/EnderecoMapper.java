package com.example.BancoMalvaderWeb.Mapper;

import com.example.BancoMalvaderWeb.DTO.EnderecoDTO;
import com.example.BancoMalvaderWeb.Model.EnderecoModel;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public EnderecoModel map(EnderecoDTO dto){
       EnderecoModel model = new EnderecoModel();

       model.setIdEndereco(dto.getIdEndereco());
       model.setCep(dto.getCep());
       model.setBairro(dto.getBairro());
       model.setLocal(dto.getLocal());
       model.setCidade(dto.getCidade());
       model.setNumeroCasa(dto.getNumeroCasa());
       model.setUsuario(dto.getUsuario());

       return model;
    }

    public EnderecoDTO map(EnderecoModel model){
        EnderecoDTO dto = new EnderecoDTO();

        dto.setIdEndereco(model.getIdEndereco());
        dto.setCep(model.getCep());
        dto.setBairro(model.getBairro());
        dto.setLocal(model.getLocal());
        dto.setCidade(model.getCidade());
        dto.setNumeroCasa(model.getNumeroCasa());
        dto.setUsuario(model.getUsuario());

        return dto;
    }
}
