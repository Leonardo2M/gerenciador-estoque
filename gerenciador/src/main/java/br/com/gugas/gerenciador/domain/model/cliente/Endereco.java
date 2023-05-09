package br.com.gugas.gerenciador.domain.model.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Endereco {

    private String logradouro;
    private String bairro;
    private String numero;

}
