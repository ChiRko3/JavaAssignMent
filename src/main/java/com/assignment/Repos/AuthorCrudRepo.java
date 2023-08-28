package com.assignment.Repos;

import com.assignment.Models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorCrudRepo extends MongoRepository<Author,String> {

}
