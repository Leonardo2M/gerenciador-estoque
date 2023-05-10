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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "numeros", column = @Column(name = "CPF"))
    })
    private CPF cpf;
    @Embedded
    private Endereco endereco;

}
