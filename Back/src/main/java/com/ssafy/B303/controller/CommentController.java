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
    public void insertComment(@RequestBody CommentDto comment){
        commentService.insertComment(comment);
    }

    @PutMapping(value = {"/comment/{id}"})
    public void updateComment(@PathVariable int id, @RequestBody CommentDto comment){
        if (commentService.selectCommentById(id).getUser_id() == comment.getUser_id()) { //댓글 작성자만 수정 가능
            commentService.updateComment(id, comment);
        }
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable int id, @RequestBody CommentDto comment) {
        if (commentService.selectCommentById(id).getUser_id() == comment.getUser_id()) {
            commentService.deleteComment(id);
        }
        
    }
}
