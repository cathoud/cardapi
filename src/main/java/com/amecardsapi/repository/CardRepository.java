package com.amecardsapi.repository;

import com.amecardsapi.model.Card;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository {
    Optional<Card> findById(int id);

    Card save(Card card);
}
