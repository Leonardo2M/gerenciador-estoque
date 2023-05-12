package br.com.gugas.gerenciador.dto.produto;

import br.com.gugas.gerenciador.domain.model.produto.Estoque;
import br.com.gugas.gerenciador.domain.model.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListarProduto {

    private String nome;
    private BigDecimal preco;
    private Estoque estoque;

    public ListarProduto(Produto produto) {
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
    }
}
