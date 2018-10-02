package com.example.uef.septemberworkout.model;

import java.util.Date;

public class Workout {
    private String title;
    private int weight;
    private int recordRepsCount;
    private Date recordData;
    private String description;
    private String imageUrl;

    // Время
    // Статус
    // Тип
    // Сложность


    public Workout(String title, int weight, int recordRepsCount, Date recordData, String description, String imageUrl) {
        this.title = title;
        this.weight = weight;
        this.recordRepsCount = recordRepsCount;
        this.recordData = recordData;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Workout(String title) {

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRecordRepsCount() {
        return recordRepsCount;
    }

    public void setRecordRepsCount(int recordRepsCount) {
        this.recordRepsCount = recordRepsCount;
    }

    public Date getRecordData() {
        return recordData;
    }

    public void setRecordData(Date recordData) {
        this.recordData = recordData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
