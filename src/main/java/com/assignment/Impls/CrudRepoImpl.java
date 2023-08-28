package com.assignment.Impls;

import com.assignment.Models.Book;
import com.assignment.Repos.BookRepo;

import java.util.ArrayList;
import java.util.Arrays;
import com.mongodb.client.MongoClient;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrudRepoImpl implements BookRepo {
    @Autowired
    MongoClient MC;
    @Autowired
    MongoConverter converter;
    public List<Book> searchBooks(String genre) {
        List<Book> booksWithGenre = new ArrayList<>();
        MongoDatabase database = MC.getDatabase("Project");
        MongoCollection<Document> collection = database.getCollection("Book");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text", new Document("query", genre).append("path", "genre")))));
        for(Document D : result){
            booksWithGenre.add(converter.read(Book.class,D));
        }
        return booksWithGenre;
    }

    @Override
    public List<Book> searchBooksWithCopies(String genre, Integer Copies) {
        List<Book> queryBooks = searchBooks(genre);
        List<Book> ans = new ArrayList<>();
        for(Book B : queryBooks){
            if(B.getCopies() > Copies) ans.add(B);
        }
        return ans;
    }
}
