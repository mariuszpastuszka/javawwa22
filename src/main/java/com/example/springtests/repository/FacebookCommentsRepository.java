package com.example.springtests.repository;

import com.example.springtests.entity.Comments;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository("face")
public class FacebookCommentsRepository implements DataAccess {

    @Override
    public List<Comments> readComments() {
        // TODO: connect to face and read comments...
        return Collections.emptyList();
    }
}
