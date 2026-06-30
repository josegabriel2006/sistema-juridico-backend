package br.com.josedev.sistemaJuridico.controller;

import br.com.josedev.sistemaJuridico.model.Client;
import br.com.josedev.sistemaJuridico.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<?>> getAllClients() {
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getAllClientsById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientService.getClientsById(id));
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        System.out.println("Cliente criado: " + client.getFullName());
        clientService.createClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@RequestBody Client client, @PathVariable Long id) {
        Client clientUpdated = clientService.updateClient(client, id);
        if (clientUpdated == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(clientUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }

}
