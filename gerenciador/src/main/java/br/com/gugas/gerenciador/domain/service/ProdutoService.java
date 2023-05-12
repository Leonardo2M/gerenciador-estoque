package br.com.gugas.gerenciador.domain.service;

import br.com.gugas.gerenciador.domain.model.produto.Produto;
import br.com.gugas.gerenciador.domain.repository.ProdutoRepository;
import br.com.gugas.gerenciador.dto.produto.CadastroProduto;
import br.com.gugas.gerenciador.dto.produto.ListarProduto;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ListarProduto> listar() {
        return produtoRepository.findAll().stream().map(ListarProduto::new).toList();
    }
}
