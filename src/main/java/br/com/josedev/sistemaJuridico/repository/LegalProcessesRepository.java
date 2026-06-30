package br.com.josedev.sistemaJuridico.repository;

import br.com.josedev.sistemaJuridico.model.LegalProcess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LegalProcessesRepository extends JpaRepository<LegalProcess, Long> {
}
