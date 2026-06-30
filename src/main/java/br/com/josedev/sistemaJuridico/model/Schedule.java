package br.com.josedev.sistemaJuridico.model;

import br.com.josedev.sistemaJuridico.enums.StatusSchedule;
import br.com.josedev.sistemaJuridico.enums.TypeSchedule;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeSchedule typeSchedule;
    private LocalDateTime dateTime;
    private String location;
    @ManyToOne
    @JoinColumn(name = "process_id")
    private LegalProcess process;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @Enumerated(EnumType.STRING)
    private StatusSchedule statusSchedule;
    private String observations;
}
