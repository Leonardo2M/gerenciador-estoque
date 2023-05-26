package br.com.gugas.gerenciador.domain.model.cliente;


import br.com.gugas.gerenciador.dto.cliente.AtualizarCliente;
import br.com.gugas.gerenciador.dto.produto.AtualizarProduto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "CPF"))
    })
    private CPF cpf;
    @Embedded
    private Endereco endereco;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numero", column = @Column(name = "telefone"))
    })
    private Telefone telefone;
    private Boolean ativo;

    public Cliente(String nome, CPF cpf, Endereco endereco, Telefone telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.ativo = true;
    }

    public void mudarEstadoAtivo() {
        this.ativo = !this.ativo;
    }

    public String getTelefoneDDD() {
        return this.telefone.getDdd() + " " + this.telefone.getNumero();
    }

    public void atualizar(Cliente dados) {
        if(dados.getNome() != null) {
            this.nome = dados.getNome();
        }
        if(dados.getCpf() != null) {
            this.cpf.atualizar(dados.getCpf());
        }
        if(dados.getEndereco() != null) {
            this.endereco.atualizar(dados.getEndereco());
        }
        if(dados.getTelefone() != null) {
            this.telefone.atualizar(dados.getTelefone());
        }
    }
}
