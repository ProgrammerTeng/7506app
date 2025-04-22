package com.example.myapplication.Model;


public class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;
    private int imageResId;
    private String quote;
    private int readers;

    public Book(String title, String author, String genre, double rating, int imageResId, String quote, int readers) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
        this.imageResId = imageResId;
        this.quote = quote;
        this.readers = readers;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public double getRating() { return rating; }
    public int getImageResId() { return imageResId; }
    public String getQuote() { return quote; }
    public int getReaders() { return readers; }
}
