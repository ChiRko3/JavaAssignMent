package com.testproject;
import com.mongodb.client.MongoClient;
import com.testproject.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.AggregateIterable;

@Component
public class SearchImpl implements SearchRepo{
    @Autowired
    MongoClient MC;
    @Autowired
    MongoConverter conv;
    @Override
    public List<Post> findByText(String s) {
        List<Post> L = new ArrayList<>();
        MongoDatabase database = MC.getDatabase("Jobs");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", s)
                                        .append("path", Arrays.asList("desc", "profile", "techs")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));
        for(Document P : result){
            L.add(conv.read(Post.class,P));
        }
        return L;
    }
}