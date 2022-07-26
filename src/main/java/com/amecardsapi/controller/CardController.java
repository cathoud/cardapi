package com.amecardsapi.controller;

import com.amecardsapi.controller.request.CardRequest;
import com.amecardsapi.model.Card;
import com.amecardsapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    private static final Logger LOG = LoggerFactory.getLogger(CardController.class);

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> listCards() {
        return cardService.listCards();
    }

    @GetMapping("{id}")
    public Card findCardById(@PathVariable("id") int id) {
        LOG.info("Buscando card com id {}", id);

        return cardService.findById(id);
    }

    @PostMapping
    public Card createCard(@RequestBody CardRequest cardRequest) {
        return cardService.createCard(cardRequest);
    }

    @PostMapping("{id}")
    public Card update(@PathVariable("id") Long id, @RequestBody CardRequest cardRequest) {
        return cardService.updateCard(id, cardRequest);
    }
}
