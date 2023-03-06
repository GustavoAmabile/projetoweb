package br.com.ada.locate.service;

import br.com.ada.locate.model.Aluguel;
import br.com.ada.locate.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    public void createAluguel(Aluguel aluguel) {
        this.aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarTodos() {
        return this.aluguelRepository.findAll();
    }

    public Optional<Aluguel> buscarAluguelPorId(Long id) {
        return this.aluguelRepository.findById(id);
    }

    public Long calcularQuantidadeDiarias(LocalDateTime inicio, LocalDateTime fim) {
        return ChronoUnit.DAYS.between(inicio, fim);
    }

    public BigDecimal calcularValorAluguel(Long diarias, BigDecimal desconto, BigDecimal valorDiaria ) {
        BigDecimal quantidadeDiarias = BigDecimal.valueOf(diarias);
        BigDecimal valorTotal = valorDiaria.subtract(valorDiaria.multiply(desconto));
        return  quantidadeDiarias.multiply(valorTotal);
    }


}
