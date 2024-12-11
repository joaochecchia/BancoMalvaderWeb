package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.DTO.ClienteDTO;
import com.example.BancoMalvaderWeb.Mapper.ClienteMapper;
import com.example.BancoMalvaderWeb.Model.ClienteModel;
import com.example.BancoMalvaderWeb.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteDTO findClienteById(Long id){
        return  clienteRepository.findById(id)
                .map(clienteMapper::map)
                .orElse(null);
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO){
        ClienteModel clienteModel = clienteMapper.map(clienteDTO);
        clienteModel = clienteRepository.save(clienteModel);

        return clienteMapper.map(clienteModel);
    }

    public ClienteDTO editCliente(Long id, ClienteDTO clienteDTO){
        ClienteModel clienteModel = clienteMapper.map(clienteDTO);
        clienteModel.setIdUsuario(id);
        clienteModel = clienteRepository.save(clienteModel);

        return clienteMapper.map(clienteModel);
    }

    public void deleteCliente(Long id){
        clienteRepository.deleteById(id);
    }
}
