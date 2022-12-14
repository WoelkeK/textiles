package com.ambitious.team.textiles.config.controller;

import com.ambitious.team.textiles.config.api.exception.ClientNotFoundException;
import com.ambitious.team.textiles.config.api.exception.LoginExistException;
import com.ambitious.team.textiles.config.model.Client;
import com.ambitious.team.textiles.config.service.ClientService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final Logger LOGGER = Logger.getLogger(ClientController.class.getName());

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        LOGGER.info("create(" + client + ")");
        Client createdClient = clientService.create(client);
        LOGGER.info("create(...)");
        return createdClient;
    }

    @GetMapping("/{id}")
    public Optional<Client> read(@PathVariable Long id) throws ClientNotFoundException {
        LOGGER.info("read(" + id + ")");
        var readClient = clientService.read(id);
        LOGGER.info("read(...)=" + readClient);
        return readClient;
    }

    @GetMapping("/{login}")
    public Client login(@PathVariable String login, String password) throws ClientNotFoundException {
        LOGGER.info("login()" + login + "" + password);
        Client logClient = clientService.login(login, password);
        return logClient;

    }

    @PutMapping
    public Client update(@RequestBody Client client) {
        LOGGER.info("update(" + client + ")");
        Client updatedClient = clientService.update(client);

        LOGGER.info("update(...)=" + client + ")");
        return updatedClient;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("delete(" + id + ")");
        clientService.delete(id);

        LOGGER.info("delete(...)=");
    }

    @GetMapping
    public List<Client> list() {
        LOGGER.info("list()");
        var clientList = clientService.list();
        LOGGER.info("list()=" + clientList);
        return clientList;
    }
}