package br.com.gugas.gerenciador.domain.model.cliente;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Telefone {

    private String ddd;
    private String numero;

    public void atualizar(Telefone telefone) {
        if(telefone.getDdd() != null) {
            this.ddd = telefone.getDdd();
        }
        if(telefone.getNumero() != null) {
            this.numero = telefone.getNumero();
        }
    }
}
