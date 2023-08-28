package com.assignment.Controllers;

import com.assignment.Models.Book;
import com.assignment.Repos.BookRepo;
import com.assignment.Repos.BookCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookCrudRepo CRUD;
    @Autowired
    private BookRepo bookRepo;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String getHome(){
        return "Well Done! Welcome to home page.";
    }

    // 1
    @RequestMapping(value = "/getAllBooks",method = RequestMethod.GET)
    public List<Book> getBooks(){
        List<Book> L = CRUD.findAll();
        for(Book B : L){
            System.out.println(B);
        }
        return L;
    }

    //4
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book Book){
        CRUD.insert(Book);
        return Book;
    }

    // 2
    @RequestMapping(value = "/search/{genre}", method = RequestMethod.GET)
    public List<Book> searchBooks(@PathVariable String genre){
        List<Book> ans = bookRepo.searchBooks(genre);
        for(Book B : ans){
            System.out.println(B);
        }
        return ans;
    }

    // 3
    @RequestMapping(value = "/search/{genre}/{copies}", method = RequestMethod.GET)
    public List<Book> searchBooksWithCopies(@PathVariable String genre,@PathVariable Integer copies){
        return bookRepo.searchBooksWithCopies(genre,copies);
    }
}
