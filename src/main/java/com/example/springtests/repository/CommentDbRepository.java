package com.example.springtests.repository;


import com.example.springtests.entity.Comments;

import java.util.Collections;
import java.util.List;

public class CommentDbRepository implements DataAccess {

    @Override
    public List<Comments> readComments() {
        return Collections.emptyList();
    }

}
