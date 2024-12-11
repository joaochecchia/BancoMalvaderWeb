package com.example.BancoMalvaderWeb.Service;

import com.example.BancoMalvaderWeb.Repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    public final ClienteRepository clienteRepository;
}
