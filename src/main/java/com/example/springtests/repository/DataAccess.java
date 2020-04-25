package com.example.springtests.repository;

import com.example.springtests.entity.Comments;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DataAccess {
    List<Comments> readComments();
}
