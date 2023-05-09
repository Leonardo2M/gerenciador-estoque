package br.com.gugas.gerenciador.domain.model.venda;

import br.com.gugas.gerenciador.domain.model.cliente.Cliente;
import br.com.gugas.gerenciador.domain.model.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Venda {

    private Cliente cliente;
    private Produto produto;
    private int quantidade;

}
