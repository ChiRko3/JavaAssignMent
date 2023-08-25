package com.testproject;

import com.testproject.Models.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SearchRepo {
    List<Post> findByText(String s);
}
