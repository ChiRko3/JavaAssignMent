package com.assignment.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Book")
public class Book {
    private Integer id;
    private Integer copies;
    private String authorId;
    private String genre;

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", copies=" + copies +
                ", authorId='" + authorId + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
