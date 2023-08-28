package com.assignment.Repos;

import com.assignment.Models.Book;

import java.util.List;

public interface BookRepo {
    public List<Book> searchBooks(String genre);
    public List<Book> searchBooksWithCopies(String genre,Integer Copies);
}
