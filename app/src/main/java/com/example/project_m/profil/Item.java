package com.example.project_m.profil;

public class Item {
    private String quote;
    private String author;

    public Item(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

}
