package br.com.gugas.gerenciador.domain.service;

import br.com.gugas.gerenciador.domain.exception.ClienteException;
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
        return clienteRepository.findAllByAtivoTrue().stream().map(ListarCliente::new).toList();
    }

    public List<ListarCliente> listarInativos() {
        return clienteRepository.findAllByAtivoFalse().stream().map(ListarCliente::new).toList();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new ClienteException("Cliente com id = " + id + " não foi encontrado!"));
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        cliente.desativar();
        clienteRepository.save(cliente);
    }

}