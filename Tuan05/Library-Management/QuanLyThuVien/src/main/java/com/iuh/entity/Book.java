package com.iuh.entity;

public abstract class Book {
    private String title;
    private String author;
    private String genre;
    private boolean isBorrowed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author, String genre, boolean isBorrowed) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isBorrowed = isBorrowed;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }
}
