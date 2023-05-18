package br.com.gugas.gerenciador.dto.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtualizarProduto {

    private String nome;
    private BigDecimal preco;

}
