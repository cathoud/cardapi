package com.amecardsapi.service;

import com.amecardsapi.controller.request.CreateCardRequest;
import com.amecardsapi.exception.EntityNotFoundException;
import com.amecardsapi.model.Card;
import com.amecardsapi.repository.CardOriginRepository;
import com.amecardsapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        return this.cardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Card id [" + id + "] not found."));
    }

    public Card createCard(CreateCardRequest cardRequest) {

        cardOriginRepository.findById(cardRequest.getOriginId())
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
        card.setOriginId(cardRequest.getOriginId());

        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        return cardRepository.save(card);
    }
}
