package br.com.gugas.gerenciador.domain.model.cliente;


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

    public void desativar() {
        this.ativo = false;
    }
}
