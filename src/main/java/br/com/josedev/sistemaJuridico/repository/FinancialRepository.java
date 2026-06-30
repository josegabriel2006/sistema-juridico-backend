package br.com.josedev.sistemaJuridico.repository;

import br.com.josedev.sistemaJuridico.model.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialRepository extends JpaRepository<Financial, Long> {

}
