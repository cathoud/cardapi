package com.amecardsapi.repository.impl;

import com.amecardsapi.model.Card;
import com.amecardsapi.repository.CardRepository;
import com.amecardsapi.repository.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository {

    private static final Logger LOG = LogManager.getLogger(CardRepositoryImpl.class);
    private final ConnectionFactory connectionFactory;

    @Autowired
    public CardRepositoryImpl(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Optional<Card> findById(int id) {
        String query = "SELECT * FROM card WHERE id = ?";

        try(Connection connection = connectionFactory.getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                statement.execute();

                ResultSet resultSet = statement.getResultSet();
                if(resultSet.next()) {
                    Card card = new Card();
                    card.setId(resultSet.getInt("id"));
                    card.setName(resultSet.getString("name"));
                    card.setDescription(resultSet.getString("description"));
                    card.setImageUrl(resultSet.getString("image_url"));
                    card.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
                    card.setCreatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());

                    return Optional.of(card);
                }
            }
        } catch (SQLException e) {
            LOG.error("{}", e.getMessage());
        }

        return Optional.empty();
    }

    @Override
    public Optional<Card> save(Card card) {
        String insertQuery = "INSERT INTO card (name, description, image_url, originId) VALUES (?,?,?,?)";

        try(Connection connection = connectionFactory.getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, card.getName());
                statement.setString(2, card.getDescription());
                statement.setString(3, card.getImageUrl());
                statement.setInt(4, (int) card.getCardOrigin().getId());

                statement.execute();

                ResultSet resultSet = statement.getGeneratedKeys();
                if(resultSet.next()) {
                    card.setId(resultSet.getInt(1));

                    return Optional.of(card);
                }
            }
        } catch (SQLException e) {
            LOG.error("{}", e.getMessage());
        }

        return Optional.empty();
    }
}
