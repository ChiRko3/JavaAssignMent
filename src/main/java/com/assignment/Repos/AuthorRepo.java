package com.assignment.Repos;

import com.assignment.Models.Author;
import com.assignment.Models.Book;

import java.util.List;

public interface AuthorRepo {
    public List<Author> searchAuthor(String authorName);
    public List<Book> searchByAuthor(String[] authors);
}
