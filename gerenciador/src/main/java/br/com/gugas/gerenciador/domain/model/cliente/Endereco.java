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

}
