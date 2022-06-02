package com.amecardsapi.model;

import java.time.LocalDateTime;

public class Card {
    private long id;

    private String name;

    private String description;

    private String imageUrl;

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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
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

    public String toString() {
        return "Card(id=" + this.id +
                ", name=" + this.name +
                ", description=" + this.description +
                ", imageUrl=" + this.imageUrl +
                ", strength=" + this.strength +
                ", speed=" + this.speed +
                ", skill=" + this.skill +
                ", gear=" + this.gear +
                ", intellect=" + this.intellect +
                ", createdAt=" + this.createdAt +
                ", updatedAt=" + this.updatedAt + ")";
    }
}
