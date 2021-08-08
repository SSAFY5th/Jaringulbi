package com.ssafy.B303.controller;

import com.ssafy.B303.model.dto.CommentDto;
import com.ssafy.B303.model.dto.PostDto;
import com.ssafy.B303.model.service.CommentService;
import com.ssafy.B303.model.service.CommentServiceImpl;
import com.ssafy.B303.model.service.PostServiceImpl;
import com.ssafy.B303.model.service.UpDownServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl commentService;

    @PostMapping("/comment")
    public void insertBoard(@RequestBody CommentDto comment){
        commentService.insertComment(comment);
    }

    @PutMapping(value = {"/comment/{id}"})
    public void updatePost(@PathVariable int id, @RequestBody CommentDto comment){
        commentService.updateComment(id, comment);
    }

    @DeleteMapping("/comment/{id}")
    public void deleteBoard(@PathVariable int id) {
        commentService.deleteComment(id);
    }
}
