package com.example.blogServer.controller;

import com.example.blogServer.entity.Post;
import com.example.blogServer.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            Post createdPost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        try {
            List<Post> allPosts = postService.getAllPosts();
            return ResponseEntity.status(HttpStatus.OK).body(allPosts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(value = "/{id}/{likedPost}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long id,
                                            @PathVariable(value = "likedPost") boolean likedPost) {
        try {
            Post post = postService.getPostById(id, likedPost);
            return ResponseEntity.ok(post);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value = "/{id}/like")
    public ResponseEntity<?> likePost(@PathVariable(value = "id") Long id) {
        try {
            postService.likePost(id);
            return ResponseEntity.ok(new String[]{"Post curtido com sucesso."});
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchByName(@PathVariable(value = "name") String name) {
        try {
            return ResponseEntity.ok(postService.searchByName(name));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
