package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String viewEditPostForm(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam String title, @RequestParam String body){
        Post p = new Post(
                id,
                title,
                body
        );
        postDao.save(p);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        Post post1 = postDao.getOne(id);
        postDao.delete(post1);
        return "redirect:/posts";
    }



//    @GetMapping("/posts/create")
//    @ResponseBody
//
//    public String createPostForm(){
//        return "View form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//
//    public String submitPost(){
//        return "create a new post";
//    }
}
