package com.example.springtests.controller;

import com.example.springtests.service.CommentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Controller
public class CommentsController {

    private final CommentService commentService;

    private final String COMMENTS_KEY = "comments";

    public CommentsController(@Qualifier("commentServiceImpl") final CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/user-comments")
    String getAllComments(Model model) {
        // z bezpieczeństwo wielowątkowe??
        // bezstanowość
        // bardzo wolno - 10s
        model.addAttribute(COMMENTS_KEY, commentService.readAllComments());
        return "user-comments-view";
    }

    // POJO
   //@GetMapping("/user-comments2")
   // ModelAndView

}
