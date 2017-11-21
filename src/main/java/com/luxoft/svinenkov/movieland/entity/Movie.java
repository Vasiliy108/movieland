package com.luxoft.svinenkov.movieland.entity;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private String origName;
    private int year;
    private List<Country> countries;
    private List<Genre> genres;
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
            List<Country> countries,
            List<Genre> genres,
            String description,
            float rating,
            float price,
            String posterUrl
    ) {
        this.id = id;
        this.name = name;
        this.origName = origName;
        this.year = year;
        this.countries = countries;
        this.genres = genres;
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

    public List<Country> getCountries() {
        return countries;
    }
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Genre> getGenres() {
        return genres;
    }
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
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
                ", countries='" + countries + '\'' +
                ", genres='" + genres + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", price=" + price + '\'' +
                ", posterUrl=" + posterUrl +
                '}';
    }
}
