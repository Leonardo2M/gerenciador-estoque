package br.com.gugas.gerenciador.domain.repository;

import br.com.gugas.gerenciador.domain.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
