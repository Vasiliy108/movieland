package com.luxoft.svinenkov.movieland.entity;

public class Movie {
    private int id;
    private String name;
    private String origName;
    private int year;
    private String description;
    private float rating;
    private float price;
    private String posterUrl;

    public Movie() {
    }

    public Movie(
            int id,
            String name,
            String origName,
            int year,
            String description,
            float rating,
            float price,
            String posterUrl
    ) {
        this.id = id;
        this.name = name;
        this.origName = origName;
        this.year = year;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.posterUrl = posterUrl;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOrigName() {
        return origName;
    }
    public void setOrigName(String origName) {
        this.origName = origName;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public String getPosterURL() {
        return posterUrl;
    }
    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origName='" + origName + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", price=" + price + '\'' +
                ", posterUrl=" + posterUrl +
                '}';
    }
}
