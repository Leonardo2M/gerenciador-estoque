package br.com.gugas.gerenciador.domain.service;

import br.com.gugas.gerenciador.domain.model.produto.Produto;
import br.com.gugas.gerenciador.domain.repository.ProdutoRepository;
import br.com.gugas.gerenciador.dto.produto.CadastroProduto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvar(CadastroProduto dados) {
        Produto produto = dados.toProduto();
        produtoRepository.save(produto);
    }
}
