package org.library.book.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {

    @Id
    private String book_id;
    private String title;
    private String author;
    private String editing;
    private int year;
    private String category;

    public String getBook_id() {
        return book_id;
    }
    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditing() {
        return editing;
    }
    public void setEditing(String editing) {
        this.editing = editing;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Title: " +this.title + " ,Author: " + this.author + "\n" +
                "Editing: " +this.editing + " ,Category: " + this.category + "\n" +
                "Year: " +this.year;
    }
}
