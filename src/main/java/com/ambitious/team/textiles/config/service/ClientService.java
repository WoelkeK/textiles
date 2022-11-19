package com.ambitious.team.textiles.config.service;

import com.ambitious.team.textiles.config.controller.ClientController;
import com.ambitious.team.textiles.config.model.Client;
import com.ambitious.team.textiles.config.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClientService {

    private final Logger LOGGER = Logger.getLogger(ClientController.class.getName());

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // C - create
    public Client create(Client client) {
        LOGGER.info("create(" + client + ")");

        Client createdClient = clientRepository.save(client);

        LOGGER.info("create(...)=" + createdClient);
        return createdClient;
    }

    // R - read
    public Client read(Long id) {
        LOGGER.info("read(" + id + ")");
        Optional<Client> optionalClient = clientRepository.findById(id);
        var readClient = optionalClient.orElse(new Client());

        LOGGER.info("read(...)=" + readClient);
        return readClient;
    }

    // U - update
    public Client update(Client client) {
        LOGGER.info("update(" + client + ")");

        Client updatedClient = clientRepository.save(client);

        LOGGER.info("update(...)=" + updatedClient);
        return updatedClient;
    }

    // D - delete
    public void delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        var deletedClient = clientRepository.findById(id);
        clientRepository.delete(deletedClient.orElseThrow());

        LOGGER.info("delete(...)");
    }

    // L - list
    public List<Client> list() {
        LOGGER.info("list()");

        var clientList = clientRepository.findAll();

        LOGGER.info("list()=" + clientList);
        return clientList;
    }
}