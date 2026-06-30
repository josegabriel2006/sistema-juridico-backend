package br.com.josedev.sistemaJuridico.service;

import br.com.josedev.sistemaJuridico.model.Client;
import br.com.josedev.sistemaJuridico.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientsById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente de id: " + id + ", não foi encontrado."));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Client client, Long id) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente de id: " + id + ", não encontrado no banco de dados."));
        existingClient.setFullName(client.getFullName());
        existingClient.setBirthDate(client.getBirthDate());
        existingClient.setPersonType(client.getPersonType());
        existingClient.setCpf(client.getCpf());
        existingClient.setRg(client.getRg());
        existingClient.setMaritalStatus(client.getMaritalStatus());
        existingClient.setProfession(client.getProfession());
        existingClient.setNationality(client.getNationality());
        existingClient.setPhone(client.getPhone());
        existingClient.setSecondaryPhone(client.getSecondaryPhone());
        existingClient.setEmail(client.getEmail());
        existingClient.setWhatsapp(client.getWhatsapp());
        existingClient.setZipCode(client.getZipCode());
        existingClient.setStreet(client.getStreet());
        existingClient.setNumber(client.getNumber());
        existingClient.setComplement(client.getComplement());
        existingClient.setNeighborhood(client.getNeighborhood());
        existingClient.setCity(client.getCity());
        existingClient.setHowDidYouMeetUs(client.getHowDidYouMeetUs());
        existingClient.setObservations(client.getObservations());
        return clientRepository.save(existingClient);
    }

    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
