package br.com.gugas.gerenciador.domain.repository;

import br.com.gugas.gerenciador.domain.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByAtivoTrue();
    List<Cliente> findAllByAtivoFalse();

}
