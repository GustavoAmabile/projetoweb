package br.com.ada.locate.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_aluguel")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    private LocalDateTime retirada;
    private LocalDateTime devolucao;
    private Long diarias;
    private BigDecimal valorDiaria;
    private BigDecimal valorAluguel;
    private BigDecimal valorComDesconto;

}
