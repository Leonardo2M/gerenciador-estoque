package br.com.gugas.gerenciador.dto.produto;

import br.com.gugas.gerenciador.domain.model.produto.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroProduto {

    @NotBlank
    private String nome;
    @NotNull
    private BigDecimal preco;

    public Produto toProduto() {
        return new Produto(nome, preco);
    }
}
