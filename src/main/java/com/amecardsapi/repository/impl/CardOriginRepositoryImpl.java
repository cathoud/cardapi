package com.amecardsapi.repository.impl;

import com.amecardsapi.model.CardOrigin;
import com.amecardsapi.repository.CardOriginRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

//@Repository
//public class CardOriginRepositoryImpl implements CardOriginRepository {
//
//    private static final Logger LOG = LogManager.getLogger(CardOriginRepositoryImpl.class);
//    private final ConnectionFactory connectionFactory;
//    @Autowired
//    public CardOriginRepositoryImpl(ConnectionFactory connectionFactory) {
//        this.connectionFactory = connectionFactory;
//    }
//
//    @Override
//    public Optional<CardOrigin> findById(int id) {
//        String query = "SELECT * FROM origin WHERE id = ?";
//
//        try(Connection connection = connectionFactory.getConnection()) {
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setInt(1, id);
//                statement.execute();
//
//                ResultSet resultSet = statement.getResultSet();
//                if (resultSet.next()) {
//                    CardOrigin cardOrigin = new CardOrigin();
//                    cardOrigin.setId(resultSet.getInt("id"));
//                    cardOrigin.setName(resultSet.getString("name"));
//                    cardOrigin.setDescription(resultSet.getString("description"));
//                    cardOrigin.setCreator(resultSet.getString("creator"));
//                    cardOrigin.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
//                    cardOrigin.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());
//
//                    return Optional.of(cardOrigin);
//                }
//            }
//        } catch (SQLException e) {
//            LOG.error("{}", e.getMessage());
//        }
//
//        return Optional.empty();
//    };
//
//    @Override
//    public CardOrigin save(CardOrigin cardOrigin) {
////        var cardOriginFound = cardOrigins.stream()
////                .filter(storedCard -> storedCard.getName().equals(cardOrigin.getName()))
////                .findFirst();
////
////        if(cardOriginFound.isPresent()) {
////            throw new InvalidEntityAttributeException("Card origin name [" + cardOrigin.getName() + "] already stored");
////        }
////
////        cardOrigin.setId(cardOrigins.size() + 1);
////        cardOrigins.add(cardOrigin);
//
//        return cardOrigin;
//    }
//}
