package com.amecardsapi.repository.impl;

import com.amecardsapi.model.Card;
import com.amecardsapi.repository.CardRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private final List<Card> cards;

    public CardRepositoryImpl() {
        cards = new ArrayList<>();

        var card = new Card();
        card.setId(1);
        card.setName("Iron Man");
        card.setDescription("Tony Stark");
        card.setImageUrl("ironManImageUrl");
        card.setStrength(5);
        card.setSpeed(5);
        card.setGear(5);
        card.setIntellect(5);
        card.setSkill(5);
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        cards.add(card);

        card = new Card();
        card.setId(2);
        card.setName("Spider Man");
        card.setDescription("Peter Parker");
        card.setImageUrl("spiderManImageUrl");
        card.setStrength(5);
        card.setSpeed(5);
        card.setGear(5);
        card.setIntellect(5);
        card.setSkill(5);
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        cards.add(card);
    }
    @Override
    public Optional<Card> findById(int id) {
        return cards.stream().filter(card -> card.getId() == id).findFirst();
    }
}
