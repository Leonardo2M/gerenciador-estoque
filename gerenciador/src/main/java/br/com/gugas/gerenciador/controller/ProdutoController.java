package br.com.gugas.gerenciador.controller;

import br.com.gugas.gerenciador.domain.service.ProdutoService;
import br.com.gugas.gerenciador.dto.produto.AtualizarProduto;
import br.com.gugas.gerenciador.dto.produto.CadastroProduto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
    public String cadastrarProduto(CadastroProduto cadastroProduto) {
        return "produtos/produto-form";
    }

    @PostMapping ("/cadastrar")
    public String salvar(@Valid CadastroProduto dados, BindingResult result) {
        if(result.hasErrors()) {
            return "produtos/produto-form";
        }

        service.salvar(dados);
        return "redirect:/produto/listar";
    }

    @GetMapping("/listar")
    public ModelAndView listarProdutos() {
        ModelAndView mv = new ModelAndView("produtos/produtos-cadastrados");
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

    @GetMapping("/atualizar/{id}")
    public ModelAndView atualizar(@PathVariable Long id) {
        AtualizarProduto atualizarProduto = service.atualizarPorId(id);

        ModelAndView mv = new ModelAndView("produtos/produto-atualizar-form");
        mv.addObject("atualizarProduto", atualizarProduto);

        return mv;
    }


    @PostMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable Long id, @Valid @ModelAttribute("atualizarProduto") AtualizarProduto dados, BindingResult result) {
        if (result.hasErrors()) {
            return "produtos/produto-atualizar-form";
        }

        service.atualizar(id, dados);
        return "redirect:/produto/listar";
    }

    @GetMapping("/excluir/{id}")
    public String deletar(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/produto/listar";
    }

}
