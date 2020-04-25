package com.example.springtests.service;


import com.example.springtests.entity.Comments;
import com.example.springtests.repository.CommentDbRepository;
import com.example.springtests.repository.DataAccess;
import com.example.springtests.repository.FacebookCommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class CommentServiceImpl implements CommentService {

    private final DataAccess commentsRepository;

    // zamień konstruktor - aby przyjmował mape String -> DataAccess
    // wybierz potrzebnego beana ręcznie
    {
        DataAccess commentDbRepository = new CommentDbRepository();
        DataAccess face = new FacebookCommentsRepository();
        Map<String, DataAccess> map = new HashMap<>();
        map.put("commentDbRepository", commentDbRepository);
        map.put("face", face);
    }
    @Autowired
    public CommentServiceImpl(final Map<String, DataAccess> beans) {
        this.commentsRepository = beans.get("face");
    }

    public CommentServiceImpl(DataAccess commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public List<Comments> readAllComments() {
        return commentsRepository.readComments();
    }
}
// mvc
// c -
// model -

// model (service/repos), vc - web // m
