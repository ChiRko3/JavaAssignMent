package com.testproject.Controllers;

import com.testproject.Models.Post;
import com.testproject.PostRepo;
import com.testproject.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    PostRepo PR;
    @Autowired
    SearchRepo SR;
    // Home Page
    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public String getHome(){
        return "Hello, Welcome To Home Page!";
    }

//     Method Return All the Posts
    @RequestMapping(value = "/getAllPost", method = RequestMethod.GET)
//    @GetMapping("/getAllPost")
    public List<Post> getPosts(){
        List<Post> E = PR.findAll();
        for(Post P : E){
            System.out.println(P);
        }
        return E;
    }

    // Method For Posting Data
    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post P){
        PR.insert(P);
        return P;
    }

    // Method For Searching Data
    @RequestMapping(value = "/search/{param}", method = RequestMethod.GET)
    public List<Post> search(@PathVariable("param") String Str){
        return SR.findByText(Str);
    }
}
