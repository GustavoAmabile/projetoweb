package br.com.ada.locate.repository;

import br.com.ada.locate.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findByPlacaContaining(String placa);
}
