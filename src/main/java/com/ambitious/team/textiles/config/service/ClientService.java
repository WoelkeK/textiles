package com.ambitious.team.textiles.config.service;

import com.ambitious.team.textiles.config.api.exception.ClientNotFoundException;
import com.ambitious.team.textiles.config.api.exception.LoginExistException;
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
    public Client create(Client client){
        LOGGER.info("create(" + client + ")");
        Client createClient = clientRepository.save(client);
        LOGGER.info("create(...)=" + createClient);
        return createClient;
    }

    // R - read
    public Optional<Client> read(Long id) throws ClientNotFoundException {
        LOGGER.info("read(" + id + ")");
        Optional<Client> optionalClient = clientRepository.findById(id);
        optionalClient.orElseThrow(() -> new ClientNotFoundException("Not found Client with" + id + " ID"));
        return optionalClient;
    }

    // L -  login
    public Client login(String login, String password) throws ClientNotFoundException {
        LOGGER.info("login(" + login + "" + password + ")");
        var clientList = clientRepository.findAll();
        for (Client client : clientList)
            if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
                Long findId = client.getId();
                Optional<Client> optionalClient = clientRepository.findById(findId);
                var readClient = optionalClient.orElse(new Client());
                LOGGER.info("login(...)=" + readClient);
                return readClient;
            }
        throw new ClientNotFoundException("Client is not found");
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