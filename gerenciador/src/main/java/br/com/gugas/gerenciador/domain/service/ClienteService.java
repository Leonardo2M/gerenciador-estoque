package br.com.gugas.gerenciador.domain.service;

import br.com.gugas.gerenciador.domain.model.cliente.Cliente;
import br.com.gugas.gerenciador.domain.repository.ClienteRepository;
import br.com.gugas.gerenciador.dto.cliente.CadastroCliente;
import br.com.gugas.gerenciador.dto.cliente.ListarCliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void salvar(CadastroCliente dados) {
        Cliente cliente = dados.toCliente();
        clienteRepository.save(cliente);
    }

    public List<ListarCliente> listar() {
        return clienteRepository.findAll().stream().map(ListarCliente::new).toList();
    }
}