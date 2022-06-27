package com.amecardsapi.service;

import com.amecardsapi.controller.request.CreateCardOriginRequest;
import com.amecardsapi.exception.EntityNotFoundException;
import com.amecardsapi.model.CardOrigin;
import com.amecardsapi.repository.CardOriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CardOriginService {
    private final CardOriginRepository cardOriginRepository;

    @Autowired
    public CardOriginService(CardOriginRepository cardOriginRepository) {
        this.cardOriginRepository = cardOriginRepository;
    }

    public CardOrigin findById(int id) {
        return this.cardOriginRepository.findById((long) id)
                .orElseThrow(() -> new EntityNotFoundException("Card origin id [" + id + "] not found."));
    }

    public CardOrigin createCardOrigin(CreateCardOriginRequest cardOriginRequest) {
        var cardOrigin = new CardOrigin();

        cardOrigin.setName(cardOriginRequest.getName());
        cardOrigin.setDescription(cardOriginRequest.getDescription());
        cardOrigin.setCreator(cardOriginRequest.getCreator());

        cardOrigin.setCreatedAt(LocalDateTime.now());
        cardOrigin.setUpdatedAt(LocalDateTime.now());

        return cardOriginRepository.save(cardOrigin);
    }
}
