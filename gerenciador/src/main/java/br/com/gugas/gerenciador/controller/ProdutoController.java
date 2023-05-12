package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.service.ProdutoService;
import br.com.gugas.gerenciador.dto.produto.CadastroProduto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping("/cadastrar")
    public String cadastrarProduto() {
        return "produtos/produtoForm";
    }

    @PostMapping ("/cadastrar")
    public String salvar(CadastroProduto dados) {
        service.salvar(dados);

        return "produtos/produtoForm";
    }

    @GetMapping
    public ModelAndView listarProdutos() {
        ModelAndView mv = new ModelAndView("produtos/produtosCadastrados");
        mv.addObject("produtos", service.listar());

        return mv;
    }

}
