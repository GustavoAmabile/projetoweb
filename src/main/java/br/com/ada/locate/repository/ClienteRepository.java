package br.com.ada.locate.repository;

import br.com.ada.locate.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByNomeContaining(String nome);

    Optional<Cliente> findByCpfContaining(String cpf);
}
