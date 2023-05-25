package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.service.ClienteService;
import br.com.gugas.gerenciador.dto.cliente.CadastroCliente;
import br.com.gugas.gerenciador.dto.cliente.ListarCliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/cadastrar")
    public String cadastrar() {
        return "cliente/cliente-form";
    }

    @PostMapping("/cadastrar")
    public String salvar(@ModelAttribute CadastroCliente dados) {
        service.salvar(dados);
        return "redirect:/clientes/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listarClientes() {
        ModelAndView mv = new ModelAndView("cliente/clientes-cadastrados");
        List<ListarCliente> lista = service.listar();
        lista.forEach(System.out::println);
        mv.addObject("clientes", service.listar());
        return mv;
    }
}
