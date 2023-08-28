package com.assignment.Repos;

import com.assignment.Models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookCrudRepo extends MongoRepository<Book,String> {

}