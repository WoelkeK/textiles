package com.ambitious.team.textiles.config.service;

import com.ambitious.team.textiles.config.model.Receiver;
import com.ambitious.team.textiles.config.repository.ReceiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ReceiverService {

    private static final Logger LOGGER = Logger.getLogger(ReceiverService.class.getName());
    private final ReceiverRepository receiverRepository;

    public List<Receiver> getList() {
        LOGGER.info("getList()");

        List<Receiver> receivers = receiverRepository.findAll();
        LOGGER.info("getList(...)");
        return receivers;
    }

    public Receiver create(Receiver receiver) {
        LOGGER.info("create()");
        Receiver createdReceiver = receiverRepository.save(receiver);
        LOGGER.info("create(...)");
        return createdReceiver;
    }

    public Receiver read(Long id) {
        LOGGER.info("read(" + ")");
        Optional<Receiver> receiver = receiverRepository.findById(id);
        LOGGER.info("read(...)");
        return receiver.orElseThrow();
    }

    public Receiver update(Receiver receiver) {
        LOGGER.info("update()");
        Receiver editableReceiver = receiverRepository.findById(receiver.getId()).orElseThrow();
        editableReceiver.setReceiverId(receiver.getReceiverId());
        editableReceiver.setId(receiver.getId());
        editableReceiver.setReceiverId(receiver.getReceiverId());
        editableReceiver.setName(receiver.getName());
        editableReceiver.setAddress(receiver.getAddress());
        editableReceiver.setCarbonFootprint(receiver.getCarbonFootprint());
        editableReceiver.setTokens(receiver.getTokens());
        Receiver updatedReceiver = receiverRepository.save(receiver);
        LOGGER.info("update(...)");
        return updatedReceiver;
    }

    public void delete(Long id) {
        LOGGER.info("delete()");
        Optional<Receiver> deletedReceiver = receiverRepository.findById(id);
        receiverRepository.delete(deletedReceiver.orElseThrow());
        LOGGER.info("delete(...)");
    }
}
