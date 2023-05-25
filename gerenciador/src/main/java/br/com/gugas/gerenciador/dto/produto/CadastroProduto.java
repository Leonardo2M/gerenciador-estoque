package br.com.gugas.gerenciador.dto.produto;

import br.com.gugas.gerenciador.domain.model.produto.Produto;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CadastroProduto {

    @NotBlank(message = "Digite um nome válido.")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;

    @NotNull(message = "Digite um preço válido.")
    @DecimalMin(value = "1", message = "O preço deve ser maior ou igual a 1.")
    private BigDecimal preco;


    public Produto toProduto() {
        return new Produto(nome, preco);
    }
}
