package com.example.blogServer.service;

import com.example.blogServer.entity.Comment;

public interface CommentService {

    public Comment createComment(Long postId, String postedBy, String content);
}
