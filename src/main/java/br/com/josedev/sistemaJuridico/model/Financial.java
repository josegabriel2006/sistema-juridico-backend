package br.com.josedev.sistemaJuridico.model;

import br.com.josedev.sistemaJuridico.enums.FeeType;
import br.com.josedev.sistemaJuridico.enums.StatusFinancial;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Financial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private BigDecimal totalValue;
    private BigDecimal paidValue;
    private LocalDate dueDate;
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private FeeType feeType;

    @Enumerated(EnumType.STRING)
    private StatusFinancial statusFinancial;

    @ManyToOne
    private Client client;

    @ManyToOne
    private LegalProcess legalProcess;

    private String observations;
}
