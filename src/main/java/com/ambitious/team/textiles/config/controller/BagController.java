package com.ambitious.team.textiles.config.controller;

import com.ambitious.team.textiles.config.api.exception.BagNotFoundException;
import com.ambitious.team.textiles.config.model.Bag;
import com.ambitious.team.textiles.config.service.BagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/bags")
public class BagController {
    private static final Logger LOGGER = Logger.getLogger(BagController.class.getName());
    private BagService bagService;

    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    // C - create
    @PostMapping("/api/")
    public Bag create(
            @RequestBody Bag bag) {
        LOGGER.info("create(" + bag + ")");
        Bag createdBag = bagService.create(bag);
        LOGGER.info("create(...)" + createdBag);
        return createdBag;
    }

    // R - read
    @GetMapping("/api/bags/")
    public Bag read(
            @PathVariable(name = "id") Long id)
            throws BagNotFoundException {
        LOGGER.info("read()"+ id);
        Bag readBag = bagService.read(id);
        return readBag;
    }

    // U - update
    @PutMapping("/api/bags/")
    public Bag update(
            @RequestBody Bag bag) {
        LOGGER.info("update(" + bag + ")");
        Bag updateBag = bagService.update(bag);
        LOGGER.info("update(...)" + updateBag);
        return updateBag;
    }

    // D - delete
    @DeleteMapping("/api/bags/{id}")
    public void delete(
            @PathVariable(name = "id") Long id) throws BagNotFoundException {
        LOGGER.info("delete(" + id + ")");
        bagService.delete(id);
    }

    // L - list
    @GetMapping("/api/bags")
    public List<Bag> list(Bag bag) {
        List<Bag> bags = bagService.list();
        LOGGER.info("list() = " + bags);
        return bags;
    }
}
