package com.amecardsapi.repository.impl;

import com.amecardsapi.model.Card;
import com.amecardsapi.repository.CardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private static final Logger LOG = LogManager.getLogger(CardRepositoryImpl.class);
    private final List<Card> cards = new ArrayList<>();
    private long currentId = 0;

    @Override
    public Optional<Card> findById(int id) {
        return cards.stream().filter(card -> card.getId() == id).findFirst();
    }

    @Override
    public Card save(Card card) {
        var cardFound = cards.stream()
                .filter(storedCard -> storedCard.getName().equals(card.getName()))
                .findFirst();

        if(cardFound.isPresent()) {
            throw new RuntimeException("Card already stored");
        }

        card.setId(currentId++);
        cards.add(card);

        return card;
    }

    @Override
    public List<Card> listCards() {
        return cards;
    }
}
