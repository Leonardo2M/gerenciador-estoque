package br.com.gugas.gerenciador.domain.model.produto;

import br.com.gugas.gerenciador.domain.model.venda.Venda;
import br.com.gugas.gerenciador.dto.produto.AtualizarProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "produtos")
public class Produto {

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = new Estoque(0, 0);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @Embedded
    private Estoque estoque;
    @ManyToMany(mappedBy = "produtos")
    private Set<Venda> vendas = new HashSet<>();

    public void atualizarDados(AtualizarProduto dados) {
        if(dados.getNome() != null && !dados.getNome().equals("")) {
            this.nome = dados.getNome();
        }
        if(dados.getPreco() != null) {
            this.preco = dados.getPreco();
        }
    }
}
