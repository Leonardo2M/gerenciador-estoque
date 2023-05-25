package br.com.gugas.gerenciador.dto.cliente;

import br.com.gugas.gerenciador.domain.model.cliente.CPF;
import br.com.gugas.gerenciador.domain.model.cliente.Cliente;
import br.com.gugas.gerenciador.domain.model.cliente.Endereco;
import br.com.gugas.gerenciador.domain.model.cliente.Telefone;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListarCliente {

    private String nome;
    private CPF cpf;
    private Endereco endereco;
    private Telefone telefone;

    public ListarCliente(Cliente cliente) {
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.endereco = cliente.getEndereco();
        this.telefone = cliente.getTelefone();
    }
}
