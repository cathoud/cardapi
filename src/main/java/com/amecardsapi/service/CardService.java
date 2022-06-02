package com.amecardsapi.service;

import com.amecardsapi.controller.request.CreateCardRequest;
import com.amecardsapi.model.Card;
import com.amecardsapi.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CardService {
    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Optional<Card> findByUuid(int id) {
        return this.cardRepository.findById(id);
    }

    public Card createCard(CreateCardRequest cardRequest) {
        var card = new Card();

        card.setName(cardRequest.getName());
        card.setDescription(cardRequest.getDescription());
        card.setImageUrl(cardRequest.getImageUrl());

        card.setStrength(cardRequest.getStrength());
        card.setSpeed(cardRequest.getSpeed());
        card.setIntellect(cardRequest.getIntellect());
        card.setGear(cardRequest.getGear());
        card.setSkill(cardRequest.getSkill());

        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        return cardRepository.save(card);
    }
}
