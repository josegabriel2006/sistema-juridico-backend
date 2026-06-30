package br.com.josedev.sistemaJuridico.repository;

import br.com.josedev.sistemaJuridico.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
