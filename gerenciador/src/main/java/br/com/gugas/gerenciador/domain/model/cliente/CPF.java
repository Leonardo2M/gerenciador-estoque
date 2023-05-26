package br.com.gugas.gerenciador.domain.model.cliente;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class CPF {

    private String numero;

    public void atualizar(CPF cpf) {
        if(cpf.getNumero() != null) {
            this.numero = cpf.getNumero();
        }
    }
}
