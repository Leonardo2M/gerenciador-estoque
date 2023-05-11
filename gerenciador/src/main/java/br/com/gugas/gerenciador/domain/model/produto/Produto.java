package br.com.gugas.gerenciador.domain.model.produto;

import br.com.gugas.gerenciador.domain.model.venda.Venda;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal preco;
    @OneToMany(mappedBy = "produto")
    private List<Estoque> estoques = new ArrayList<>();
    @ManyToMany(mappedBy = "produtos")
    private Set<Venda> vendas = new HashSet<>();

}
