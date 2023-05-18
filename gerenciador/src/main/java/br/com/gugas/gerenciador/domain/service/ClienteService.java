package br.com.gugas.gerenciador.domain.service;

import br.com.gugas.gerenciador.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
}