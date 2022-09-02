package com.amecardsapi.repository;

import com.amecardsapi.model.CardOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardOriginRepository extends JpaRepository<CardOrigin, Long> {
}
