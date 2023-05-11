package br.com.gugas.gerenciador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("/cadastrar")
    public String cadastrarProduto() {
        return "produtos/produtoForm";
    }

}
