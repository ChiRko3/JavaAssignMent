package com.assignment.Impls;

import com.assignment.Models.Author;
import com.assignment.Models.Book;
import com.assignment.Repos.AuthorRepo;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AuthorImpl implements AuthorRepo {
    @Autowired
    MongoClient MC;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Author> searchAuthor(String authorName) {
        List<Author> author = new ArrayList<>();
        MongoDatabase database = MC.getDatabase("Project");
        MongoCollection<Document> collection = database.getCollection("Author");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text", new Document("query", authorName).append("path", "name")))));
        for(Document D : result){
            author.add(converter.read(Author.class,D));
        }
        return author;
    }

    @Override
    public List<Book> searchByAuthor(String[] authors) {
        List<Book> finalAnswer = new ArrayList<>();
        MongoDatabase database = MC.getDatabase("Project");
        MongoCollection<Document> collection = database.getCollection("Author");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text", new Document("query", Arrays.asList(authors)).append("path", "name")))));
        List<Author> authorList = new ArrayList<>();
        for(Document D : result){
            authorList.add(converter.read(Author.class,D));
        }
        String[] authorId = new String[authorList.size()];
        for(int i = 0;i < authorList.size();i++){
            authorId[i] = authorList.get(i).getId();
        }
        finalAnswer = getBooksByAuthor(authorId);
        return finalAnswer;
    }

    private List<Book> getBooksByAuthor(String[] authorList) {
        List<Book> ans = new ArrayList<>();
        MongoDatabase database = MC.getDatabase("Project");
        MongoCollection<Document> collection = database.getCollection("Book");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text", new Document("query", Arrays.asList(authorList)).append("path", "authorId")))));
        for(Document D : result){
            ans.add(converter.read(Book.class,D));
        }
        return ans;
    }
}
