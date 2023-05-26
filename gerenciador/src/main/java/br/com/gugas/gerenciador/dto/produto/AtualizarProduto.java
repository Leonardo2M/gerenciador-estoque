package br.com.gugas.gerenciador.dto.produto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtualizarProduto {

    @NotBlank(message = "Digite um nome válido.")
    @Size(min = 2, message = "O nome deve ter no mínimo 2 caracteres.")
    private String nome;

    @DecimalMin(value = "1", message = "O preço deve ser maior ou igual a 1.")
    private BigDecimal preco;

}
