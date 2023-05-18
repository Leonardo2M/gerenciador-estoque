package br.com.gugas.gerenciador.domain.model.produto;

import br.com.gugas.gerenciador.domain.exception.EstoqueException;
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
        if(quantidade < 0) {
            throw new EstoqueException("Não é possivel adicionar valores menor que 0");
        }
        this.quantidadeVazio += quantidade;
    }

    public void adicionarProduto(int quantidade) {
        if(quantidade < 0) {
            throw new EstoqueException("Não é possivel adicionar valores menor que 0");
        }

        if(this.quantidadeVazio < quantidade) {
            throw new EstoqueException("Não possui vasilhames suficiente");
        }

        this.quantidadeCheio += quantidade;
        this.quantidadeVazio -= quantidade;
    }
}
