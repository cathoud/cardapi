package com.amecardsapi.controller;

import com.amecardsapi.controller.request.CreateCardOriginRequest;
import com.amecardsapi.model.CardOrigin;
import com.amecardsapi.service.CardOriginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card-origin")
public class CardOriginController {

    private static final Logger LOG = LoggerFactory.getLogger(CardOriginController.class);

    @Autowired
    private CardOriginService cardOriginService;

    @GetMapping("{id}")
    public CardOrigin findCardById(@PathVariable("id") int id) {
        LOG.info("Buscando card com id {}", id);

        return cardOriginService.findById(id);
    }

    @PostMapping
    public CardOrigin createCardOrigin(@RequestBody CreateCardOriginRequest createCardOriginRequest) {
        return cardOriginService.createCardOrigin(createCardOriginRequest);
    }
}
