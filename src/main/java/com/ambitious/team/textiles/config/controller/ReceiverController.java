package com.ambitious.team.textiles.config.controller;

import com.ambitious.team.textiles.config.model.Receiver;
import com.ambitious.team.textiles.config.service.ReceiverService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/receivers")
public class ReceiverController {

    private static final Logger LOGGER = Logger.getLogger(ReceiverController.class.getName());
    private final ReceiverService receiverService;

    public ReceiverController(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    @GetMapping
    public List<Receiver> getList() {
        LOGGER.info("getList()");
        List<Receiver> receivers = receiverService.getList();
        LOGGER.info("getList(...) = " + receivers);
        return receivers;
    }

    @PostMapping
    public Receiver create(@RequestBody Receiver receiver) {
        LOGGER.info("create()");
        Receiver createdReceiver = receiverService.create(receiver);
        LOGGER.info("create(...)");
        return createdReceiver;
    }

    @GetMapping("/{id}")
    public Receiver read(@PathVariable Long id) {
        LOGGER.info("read(" + id + ")");
        Receiver rededReceiver = receiverService.read(id);
        LOGGER.info("read(...)");
        return rededReceiver;
    }

    @PutMapping
    public Receiver update(@RequestBody Receiver receiver) {
        LOGGER.info("update()");
        Receiver updatedReceiver = receiverService.update(receiver);
        LOGGER.info("update(...)");
        return updatedReceiver;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("delete()");
        receiverService.delete(id);
    }
}
