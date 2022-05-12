package com.amecardsapi.repository;

import com.amecardsapi.model.Card;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public interface CardRepository {
    Optional<Card> findById(int id);

    Optional<Card> save(Card card);
}
