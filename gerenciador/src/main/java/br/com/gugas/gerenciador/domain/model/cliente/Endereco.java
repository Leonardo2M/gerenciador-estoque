package br.com.gugas.gerenciador.domain.model.cliente;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Endereco {

    private String logradouro;
    private String bairro;
    private String numero;
    private String cidade;

    public void atualizar(Endereco endereco) {
        if(endereco.getLogradouro() != null) {
            this.logradouro = endereco.getLogradouro();
        }
        if(endereco.getBairro() != null) {
            this.bairro = endereco.getBairro();
        }
        if(endereco.getNumero() != null) {
            this.numero = endereco.getNumero();
        }
        if(endereco.getCidade() != null) {
            this.cidade = endereco.getCidade();
        }
    }
}
