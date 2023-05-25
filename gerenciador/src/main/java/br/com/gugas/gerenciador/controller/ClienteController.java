package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.service.ClienteService;
import br.com.gugas.gerenciador.dto.cliente.CadastroCliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cliente/cadastrarCliente";
    }

    @PostMapping("/cadastrar")
    public String salvar(@ModelAttribute CadastroCliente dados) {
        service.salvar(dados);
        return "cliente/cadastrarCliente";
    }
}
