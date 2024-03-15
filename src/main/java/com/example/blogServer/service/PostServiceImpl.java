package com.example.blogServer.service;

import com.example.blogServer.entity.Post;
import com.example.blogServer.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        post.setViewCount(0);
        post.setLikeCount(0);
        post.setDate(new Date());

        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long postId, boolean likedPost) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            if (!likedPost) {
                post.setViewCount(post.getViewCount() + 1);
            }
            return postRepository.save(post);
        } else {
           throw new EntityNotFoundException("Post not found");
        }
    }

    public void likePost(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
        } else {
            throw new EntityNotFoundException("Post not found with id: " + id);
        }
    }

    public List<Post> searchByName(String name) {
        return postRepository.findByNameContaining(name);
    }
}
