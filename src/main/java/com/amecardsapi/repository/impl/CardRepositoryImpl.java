package com.amecardsapi.repository.impl;

import com.amecardsapi.exception.ApplicationException;
import com.amecardsapi.model.Card;
import com.amecardsapi.model.CardOrigin;
import com.amecardsapi.repository.CardRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Optional;

//@Repository
//public class CardRepositoryImpl implements CardRepository {
//
//    private static final Logger LOG = LogManager.getLogger(CardRepositoryImpl.class);
//    private final ConnectionFactory connectionFactory;
//    @Autowired
//    public CardRepositoryImpl(ConnectionFactory connectionFactory) {
//        this.connectionFactory = connectionFactory;
//    }
//
//    @Override
//    public Optional<Card> findById(int id) {
//        String query = "SELECT * FROM card JOIN origin on card.originId = origin.id WHERE card.id = ?";
//
//        try(Connection connection = connectionFactory.getConnection()) {
//            try(PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setInt(1, id);
//                statement.execute();
//
//                ResultSet resultSet = statement.getResultSet();
//                if(resultSet.next()) {
//                    Card card = new Card();
//                    card.setId(resultSet.getInt("id"));
//                    card.setName(resultSet.getString("name"));
//                    card.setDescription(resultSet.getString("description"));
//                    card.setImageUrl(resultSet.getString("image_url"));
//                    card.setStrength(resultSet.getInt("strength"));
//                    card.setSpeed(resultSet.getInt("speed"));
//                    card.setSkill(resultSet.getInt("skill"));
//                    card.setGear(resultSet.getInt("gear"));
//                    card.setIntellect(resultSet.getInt("intellect"));
//                    card.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
//                    card.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
//
//                    CardOrigin cardOrigin = new CardOrigin();
//                    cardOrigin.setId(resultSet.getInt("origin.id"));
//                    cardOrigin.setName(resultSet.getString("origin.name"));
//                    cardOrigin.setDescription(resultSet.getString("origin.description"));
//                    cardOrigin.setCreator(resultSet.getString("origin.creator"));
//                    cardOrigin.setCreatedAt(resultSet.getTimestamp("origin.created_at").toLocalDateTime());
//                    cardOrigin.setUpdatedAt(resultSet.getTimestamp("origin.updated_at").toLocalDateTime());
//
////                    card.setCardOrigin(cardOrigin);
//
//                    return Optional.of(card);
//                }
//            }
//        } catch (SQLException e) {
//            LOG.error("{}", e.getMessage());
//        }
//
//        return Optional.empty();
//    }
//
//    @Override
//    public Card save(Card card) {
//        String insertQuery = "INSERT INTO card (name, description, image_url, strength, speed, skill, gear, intellect, created_at, updated_at, originId)" +
//                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//
//        try(Connection connection = connectionFactory.getConnection()) {
//            try(PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
//                statement.setString(1, card.getName());
//                statement.setString(2, card.getDescription());
//                statement.setString(3, card.getImageUrl());
//                statement.setInt(4, card.getStrength());
//                statement.setInt(5, card.getSpeed());
//                statement.setInt(6, card.getSkill());
//                statement.setInt(7, card.getGear());
//                statement.setInt(8, card.getIntellect());
//                statement.setTimestamp(9, Timestamp.valueOf(card.getCreatedAt()));
//                statement.setTimestamp(10, Timestamp.valueOf(card.getUpdatedAt()));
////                statement.setInt(11, (int) card.getCardOrigin().getId());
//
//                statement.execute();
//
//                ResultSet resultSet = statement.getGeneratedKeys();
//                if(resultSet.next()) {
//                    card.setId(resultSet.getInt(1));
//
//                    return card;
//                }
//            }
//        } catch (SQLException e) {
//            LOG.error("{}", e.getMessage());
//            throw new ApplicationException(e.getMessage());
//        }
//
//        throw new ApplicationException("Could not save card " + card );
//    }
//}
