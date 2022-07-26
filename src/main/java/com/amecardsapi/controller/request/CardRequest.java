package com.amecardsapi.controller.request;

public class CardRequest {
    private String name;

    private String description;

    private String imageUrl;

    private int strength;

    private int speed;

    private int skill;

    private int gear;

    private int intellect;

    private int originId;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
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

    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    public String toString() {
        return "CreateCardRequest(name=" + this.name +
                ", description=" + this.description +
                ", imageUrl=" + this.imageUrl +
                ", strength=" + this.strength +
                ", speed=" + this.speed +
                ", skill=" + this.skill +
                ", gear=" + this.gear +
                ", intellect=" + this.intellect +
                ", originId=" + originId + ")";
    }
}
