package br.com.gugas.gerenciador.domain.model.cliente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {

    private String nome;
    private CPF cpf;
    private Endereco endereco;

}
