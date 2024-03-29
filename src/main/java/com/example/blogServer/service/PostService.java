package com.example.blogServer.service;

import com.example.blogServer.entity.Post;

import java.util.List;

public interface PostService {

    Post savePost(Post post);

    List<Post> getAllPosts();

    Post getPostById(Long postId, boolean likedPost);

    void likePost(Long id);

    List<Post> searchByName(String name);
}
