package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.service.ClienteService;
import br.com.gugas.gerenciador.dto.cliente.AtualizarCliente;
import br.com.gugas.gerenciador.dto.cliente.CadastroCliente;
import br.com.gugas.gerenciador.dto.produto.AtualizarProduto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/inativos/listar")
    public ModelAndView listarInativos() {
        ModelAndView mv = new ModelAndView("cliente/clientes-inativos");
        mv.addObject("clientes", service.listarInativos());
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/inativos/reativar/{id}")
    public String reativar(@PathVariable Long id) {
        service.reativar(id);
        return "redirect:/cliente/listar";
    }

    @GetMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable Long id) {
        AtualizarCliente atualizarCliente = service.atualizarPorId(id);

        ModelAndView mv = new ModelAndView("cliente/cliente-atualizar-form");
        mv.addObject("atualizarCliente", atualizarCliente);

        return mv;
    }


    @PostMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable Long id, AtualizarCliente dados) {
        service.atualizar(id, dados);
        return "redirect:/cliente/listar";
    }
}
