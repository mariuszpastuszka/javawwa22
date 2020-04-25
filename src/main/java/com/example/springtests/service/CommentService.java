package com.example.springtests.service;

import com.example.springtests.entity.Comments;

import java.util.List;

public interface CommentService {

    List<Comments> readAllComments();
}
