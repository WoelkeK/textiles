package com.ambitious.team.textiles.config.controller;

import com.ambitious.team.textiles.config.api.exception.BagNotFoundException;
import com.ambitious.team.textiles.config.model.Bag;
import com.ambitious.team.textiles.config.service.BagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class BagController {
    private static final Logger LOGGER = Logger.getLogger(BagController.class.getName());
    private BagService bagService;

    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    // C - create
    @GetMapping
    public void createView() {
        LOGGER.info("createView()");
    }

    @PostMapping
    public void create(Bag bag) {
        LOGGER.info("create(" + bag + ")");
        Bag createdBag = bagService.create(bag);
        LOGGER.info("create(...)" + createdBag);
    }

    // R - read
    public void read(
            @PathVariable(name = "id") Long id, Bag bag)
            throws BagNotFoundException {
        LOGGER.info("read()");
        Bag readBag = bagService.read(id);
    }

    // U - update
    @GetMapping
    public void updateView(@PathVariable(name = "id") Long id, Bag bag)
            throws BagNotFoundException {
        LOGGER.info("updateView()" + id + "");
        Bag updateBag = bagService.update(bag);
    }

    @PostMapping
    public void update(Bag bag) {
        LOGGER.info("update(" + bag + ")");
        Bag updateBag = bagService.update(bag);
        LOGGER.info("update(...)" + updateBag);
    }

    // D - delete
    @GetMapping
    public void delete(
            @PathVariable(name = "id") Long id) throws BagNotFoundException {
        LOGGER.info("delete(" + id + ")");
        bagService.delete(id);
    }

    // L - list
    @GetMapping
    public void list(Bag bag) {
        List<Bag> bags = bagService.list();
        LOGGER.info("list() = " + bags);
    }
}
