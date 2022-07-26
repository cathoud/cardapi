package com.amecardsapi.service;

import com.amecardsapi.controller.request.CardRequest;
import com.amecardsapi.exception.EntityNotFoundException;
import com.amecardsapi.exception.InvalidEntityAttributeException;
import com.amecardsapi.model.Card;
import com.amecardsapi.repository.CardOriginRepository;
import com.amecardsapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    private final CardOriginRepository cardOriginRepository;

    @Autowired
    public CardService(CardRepository cardRepository, CardOriginRepository cardOriginRepository) {
        this.cardRepository = cardRepository;
        this.cardOriginRepository = cardOriginRepository;
    }

    public Card findById(int id) {
        return this.cardRepository.findById((long) id)
                .orElseThrow(() -> new EntityNotFoundException("Card id [" + id + "] not found."));
    }

    public List<Card> listCards() {
        return this.cardRepository.findAll();
    }

    public Card updateCard(Long id, CardRequest cardRequest) {

        var card = new Card(cardRequest);
        card.setId(id);

        return this.cardRepository.save(card);
    }

    public Card createCard(CardRequest cardRequest) {

        var cardOrigin = cardOriginRepository.findById((long) cardRequest.getOriginId())
                .orElseThrow(() -> new EntityNotFoundException("Card origin id [" + cardRequest.getOriginId() + "] not found."));

        var card = new Card();

        card.setName(cardRequest.getName());
        card.setDescription(cardRequest.getDescription());
        card.setImageUrl(cardRequest.getImageUrl());

        card.setStrength(cardRequest.getStrength());
        card.setSpeed(cardRequest.getSpeed());
        card.setIntellect(cardRequest.getIntellect());
        card.setGear(cardRequest.getGear());
        card.setSkill(cardRequest.getSkill());
        card.setCardOrigin(cardOrigin);

        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        try {
            return cardRepository.save(card);
        } catch (DataAccessException e) {
            throw new InvalidEntityAttributeException(e.getMostSpecificCause().getMessage());
        }
    }
}
