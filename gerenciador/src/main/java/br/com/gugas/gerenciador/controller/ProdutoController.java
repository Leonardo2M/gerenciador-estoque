package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.model.produto.Produto;
import br.com.gugas.gerenciador.domain.service.ProdutoService;
import br.com.gugas.gerenciador.dto.produto.CadastroProduto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

        return "redirect:/produto/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listarProdutos() {
        ModelAndView mv = new ModelAndView("produtos/produtosCadastrados");
        mv.addObject("produtos", service.listar());

        return mv;
    }

    @PostMapping("/adicionarCompra/{id}")
    public String addEstoque(@PathVariable Long id, @RequestParam("quantidade") String quantidade) {
        service.addCompra(id, Integer.parseInt(quantidade));
        return "redirect:/produto/listar";
    }

    @PostMapping("/adicionarProduto/{id}")
    public String addProduto(@PathVariable Long id, @RequestParam("quantidade") String quantidade) {
        service.addProduto(id, Integer.parseInt(quantidade));
        return "redirect:/produto/listar";
    }

}
