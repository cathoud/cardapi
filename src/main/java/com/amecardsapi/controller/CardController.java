package com.amecardsapi.controller;

import com.amecardsapi.controller.request.CreateCardRequest;
import com.amecardsapi.model.Card;
import com.amecardsapi.service.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("{id}")
    public Card findCardByUuid(@PathVariable("id") int id) {
        LOG.info("Buscando card com id {}", id);

        var card = cardService.findByUuid(id);

        if(card.isPresent()) {
            return card.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found");
    }

    @PostMapping
    public Card createCard(@RequestBody CreateCardRequest createCardRequest) {
        try {
            return cardService.createCard(createCardRequest);
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public List<Card> listCards() {
//        return cardService.listCards();
        return List.of(new Card());
    }
}
