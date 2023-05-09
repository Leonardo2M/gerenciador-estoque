package br.com.gugas.gerenciador.domain.model.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutoEstoque {

    private Produto produto;
    private Integer quantidadeCheio;
    private Integer quantidadeVazio;


}
