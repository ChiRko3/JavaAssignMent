package com.assignment.Controllers;

import com.assignment.Models.Author;
import com.assignment.Models.Book;
import com.assignment.Repos.AuthorCrudRepo;
import com.assignment.Repos.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorCrudRepo authorRepo;
    @Autowired
    private AuthorRepo repo;
    // 5
    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public Author addAuthor(@RequestBody Author Author){
        authorRepo.insert(Author);
        return Author;
    }
    // 6
    @RequestMapping(value = "/searchByAuthor" ,method = RequestMethod.GET)
    public List<Book> searchByAuthor(@RequestBody String[] authors){
        return repo.searchByAuthor(authors);
    }
    @RequestMapping(value = "/getAllAuthor", method = RequestMethod.GET)
    public List<Author> getAllAuthor(){
        return authorRepo.findAll();
    }

    // 7
    @RequestMapping(value = "/search/author/{authorName}", method = RequestMethod.GET)
    public List<Author> searchAuthor(@PathVariable String authorName){
        return repo.searchAuthor(authorName);
    }
}