package com.amecardsapi.controller.request;

public class CreateCardRequest {
    private String name;

    private String description;

    private String imageUrl;

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
                ", originId=" + this.originId + ")";
    }
}
