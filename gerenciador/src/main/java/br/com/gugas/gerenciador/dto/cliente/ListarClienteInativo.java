package br.com.gugas.gerenciador.dto.cliente;

import br.com.gugas.gerenciador.domain.model.cliente.CPF;
import br.com.gugas.gerenciador.domain.model.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListarClienteInativo {

    private Long id;
    private String nome;
    private CPF cpf;

    public ListarClienteInativo(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }
}
