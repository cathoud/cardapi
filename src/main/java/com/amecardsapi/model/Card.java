package com.amecardsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Set;

//@Entity
public class Card {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String description;

    private String imageUrl;

    private CardOrigin cardOrigin;

    private int strength;

    private int speed;

    private int skill;

    private int gear;

    private int intellect;
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public CardOrigin getCardOrigin() {
        return cardOrigin;
    }

    public void setCardOrigin(CardOrigin cardOrigin) {
        this.cardOrigin = cardOrigin;
    }

    public String toString() {
        return "Card(id=" + this.getId() +
                ", name=" + this.getName() +
                ", description=" + this.getDescription() +
                ", imageUrl=" + this.getImageUrl() +
                ", createdAt=" + this.getCreatedAt() +
                ", updatedAt=" + this.getUpdatedAt() + ")";
    }
}
