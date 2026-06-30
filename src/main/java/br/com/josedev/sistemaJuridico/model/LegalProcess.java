package br.com.josedev.sistemaJuridico.model;

import br.com.josedev.sistemaJuridico.enums.ClientPole;
import br.com.josedev.sistemaJuridico.enums.FeeType;
import br.com.josedev.sistemaJuridico.enums.LegalArea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "processes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LegalProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processNumber;
    @Enumerated(EnumType.STRING)
    private LegalArea legalArea;
    private String actionType;
    private LocalDate distributionDate;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Enumerated(EnumType.STRING)
    private ClientPole clientPole;
    private String adverseParty;
    private String adversePartyLawyer;
    private String court;
    private String courtDivision;
    private String district;
    private String state;
    private BigDecimal caseValue;
    private BigDecimal requestValue;
    private BigDecimal feeValue;
    @Enumerated(EnumType.STRING)
    private FeeType feeType;
    private String actionDescription;
}
