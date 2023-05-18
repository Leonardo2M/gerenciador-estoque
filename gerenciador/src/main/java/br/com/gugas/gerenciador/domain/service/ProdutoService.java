package br.com.gugas.gerenciador.domain.service;

import br.com.gugas.gerenciador.domain.exception.ProdutoException;
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

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoException("Id não encontrado."));
    }

    public void addProduto(Long id, int quantidade) {
        Produto produto = buscarPorId(id);
        produto.getEstoque().adicionarProduto(quantidade);
        produtoRepository.save(produto);
    }

    public void addCompra(Long id, int quantidade) {
        Produto produto = buscarPorId(id);
        produto.getEstoque().adicionarCompra(quantidade);
        produtoRepository.save(produto);
    }
}
