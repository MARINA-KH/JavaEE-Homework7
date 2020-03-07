package com.example.demo;

public class Book {

    private String _isbn;
    private String _title;
    private String _author;



    public Book(String isbn, String title, String author) {
        this._isbn = isbn;
        this._title = title;
        this._author = author;
    }


    public Book() {

    }



    public String getIsbn() {
        return _isbn;
    }

    public void setIsbn(String _isbn) {
        this._isbn = _isbn;
    }


    public String getTitle() {
        return _title;
    }

    public void setTitle(String _title) {
        this._title = _title;
    }


    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String _author) {
        this._author = _author;
    }


    @Override
    public String toString() {
        return "Book ISBN: " + _isbn + " Title: " + _title + "Author: " + _author;
    }


}
