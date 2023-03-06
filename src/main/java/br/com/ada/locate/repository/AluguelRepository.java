package br.com.ada.locate.repository;

import br.com.ada.locate.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {


}
