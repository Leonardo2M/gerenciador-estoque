package br.com.gugas.gerenciador.domain.model.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    private String nome;
    private BigDecimal preco;

}
