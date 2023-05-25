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
public class CadastroCliente {

    private String nome;
    private String cpf;
    private String logradouro;
    private String bairro;
    private String numeroCasa;
    private String cidade;
    private String telefone;

    public Cliente toCliente() {
        CPF cpf = new CPF(this.cpf);
        Endereco endereco = new Endereco(this.logradouro, this.bairro, this.numeroCasa, this.cidade);
        Telefone telefone = new Telefone(this.telefone.substring(0,2), this.telefone.substring(3, 12));
        return new Cliente(this.nome, cpf, endereco, telefone);
    }
}
