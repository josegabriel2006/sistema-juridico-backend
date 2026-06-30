package br.com.josedev.sistemaJuridico.repository;

import br.com.josedev.sistemaJuridico.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
