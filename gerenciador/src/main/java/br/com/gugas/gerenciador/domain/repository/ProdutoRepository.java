package br.com.gugas.gerenciador.domain.repository;

import br.com.gugas.gerenciador.domain.model.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
