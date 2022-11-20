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
    public Client create(Client client, String login) throws LoginExistException {
        LOGGER.info("create(" + client + ")");
        var clientList = clientRepository.findAll();
        for (Client createdClient : clientList)
            if (createdClient.getLogin().equals(login)) {
                throw new LoginExistException("Login Exist");
            } else {
                Client createClient = clientRepository.save(client);
                LOGGER.info("create(...)=" + createClient);
                return createClient;
            } throw new LoginExistException("Create Client fold");
    }

    // R - read
    public Client read(String login, String password) throws ClientNotFoundException {
        LOGGER.info("read(" + login + ")");
        var clientList = clientRepository.findAll();
        for (Client client : clientList)
            if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
                Long findId = client.getId();
                Optional<Client> optionalClient = clientRepository.findById(findId);
                var readClient = optionalClient.orElse(new Client());
                LOGGER.info("read(...)=" + readClient);
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