package br.com.gugas.gerenciador.domain.model.produto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Estoque {

    private Integer quantidadeCheio;
    private Integer quantidadeVazio;

    public void adicionarCompra(int quantidade) {
        this.quantidadeVazio += quantidade;
    }

    public void adicionarProduto(int quantidade) {
        this.quantidadeCheio += quantidade;
        this.quantidadeVazio -= quantidade;
    }
}
