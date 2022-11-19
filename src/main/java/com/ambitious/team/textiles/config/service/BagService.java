package com.ambitious.team.textiles.config.service;

import com.ambitious.team.textiles.config.model.Bag;
import com.ambitious.team.textiles.config.repository.BagRepository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class BagService {
    private static final Logger LOGGER = Logger.getLogger(BagService.class.getName());
    private BagRepository bagRepository;

    public BagService(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    // C - create
    public Bag create(Bag bag) {
        LOGGER.info("create(" + bag + ")");
        Bag createdBag = bagRepository.save(bag);
        LOGGER.info("create(...)" + createdBag);
        return createdBag;
    }

    // R - read
    public Bag read(Long bagId) {
        LOGGER.info("read(" + bagId + ")");
        Optional<Bag> optionalBag = bagRepository.findById(bagId);
        Bag bag = optionalBag.orElseThrow(() -> new RuntimeException("Not found Bag with" + bagId + " ID"));
        LOGGER.info("read(...)" + bag);
        return bag;
    }

    // U - update
    public Bag update(Bag bag) {
        LOGGER.info("update(" + bag + ")");
        Bag savedBag = bagRepository.save(bag);
        LOGGER.info("update(...)" + savedBag);
        return savedBag;
    }

    // D - delete
    public void delete(Long bagId) {
        LOGGER.info("delete()" + bagId);
        Optional<Bag> byId = bagRepository.findById(bagId);
        Bag bag = byId.orElseThrow(() -> new RuntimeException("Not found Bag with" + bagId + " ID"));
        bagRepository.delete(bag);
        LOGGER.info("delete(...)" + bag);
    }

    // L - list
    public List<Bag> list() {
        LOGGER.info("list()");
        List<Bag> bags = bagRepository.findAll();
        LOGGER.info("list(...)" + bags);
        return bags;
    }
}
