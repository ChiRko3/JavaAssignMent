package com.testproject;

import com.testproject.Models.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface PostRepo extends MongoRepository<Post,String> {

}
