package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostImage;
import com.codeup.springblog.repositories.ImageRepository;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private ImageRepository imageDao;

    public PostController(PostRepository postDao, ImageRepository imageDao) {
        this.postDao = postDao;
        this.imageDao = imageDao;
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

    @GetMapping("/posts/{id}/history")
    public String returnTestView(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/history";
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

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        System.out.println("Does this run?");
        postDao.deleteById(id);
        return "redirect:/posts";
    }

//    @PostMapping("/posts/{id}/add-image")
//    public String addImage(
//            @PathVariable long id,
//            @RequestParam String title,
//            @RequestParam String url
//    ) {
//        PostImage image = new PostImage(title, url);
//
//    }


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
