package com.example.uef.septemberworkout.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Workout {
    private String title;
    private int recordWeight;
    private int recordRepsCount;
    private Date recordDate;
    private String description;
    private String imageUrl;

    // Время
    // Статус
    // Тип
    // Сложность

    public Workout(String title, String description, int recordWeight, Date recordDate, int recordRepsCount, String imageUrl) {
        this.title = title;
        this.recordWeight = recordWeight;
        this.recordRepsCount = recordRepsCount;
        this.recordDate = recordDate;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Workout(String title) {

        this.title = title;
    }

    public String getFormattedRecordDate() {
        return new SimpleDateFormat("dd.MM.YYYY", Locale.ROOT).format(recordDate);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public int getRecordWeight() {

        return recordWeight;
    }

    public void setRecordWeight(int recordWeight) {

        this.recordWeight = recordWeight;
    }

    public int getRecordRepsCount() {

        return recordRepsCount;
    }

    public void setRecordRepsCount(int recordRepsCount) {

        this.recordRepsCount = recordRepsCount;
    }

    public Date getRecordDate() {

        return recordDate;
    }

    public void setRecordDate(Date recordDate) {

        this.recordDate = recordDate;
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
