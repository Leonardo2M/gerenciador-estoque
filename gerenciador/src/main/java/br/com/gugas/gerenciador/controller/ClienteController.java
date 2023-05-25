package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.service.ClienteService;
import br.com.gugas.gerenciador.dto.cliente.CadastroCliente;
import br.com.gugas.gerenciador.dto.cliente.ListarCliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
        return "redirect:/cliente/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listarClientes() {
        ModelAndView mv = new ModelAndView("cliente/clientes-cadastrados");
        mv.addObject("clientes", service.listar());
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/cliente/listar";
    }
}
