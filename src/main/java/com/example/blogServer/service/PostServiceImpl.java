package com.example.blogServer.service;

import com.example.blogServer.entity.Post;
import com.example.blogServer.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
