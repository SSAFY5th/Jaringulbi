package com.ssafy.B303.controller;

import com.ssafy.B303.model.dto.CommentDto;
import com.ssafy.B303.model.dto.PostDto;
import com.ssafy.B303.model.dto.UserDto;
import com.ssafy.B303.model.service.CommentServiceImpl;
import com.ssafy.B303.model.service.PostServiceImpl;
import com.ssafy.B303.model.service.UpDownServiceImpl;
import com.ssafy.B303.model.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
public class PostController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UpDownServiceImpl upDownService;

    @Autowired
    CommentServiceImpl commentService;

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/board")
    public List<PostDto> selectAllPost() throws Exception {
        List<PostDto> postDtoList = postService.selectAllPost(1);
        for (PostDto postDto: postDtoList) {
            int id = postDto.getId();
            UserDto user = userService.selectUserById(postDto.getUser_id());
            postDto.setNickname(user.getNickname());
            postDto.setUp(upDownService.selectUpById(id));
            postDto.setUpCount(upDownService.getUpCount(id));
            postDto.setCommentCount(commentService.getCommentCount(id));
        }
        return postDtoList;
    }

    @GetMapping("/buyornot")
    public List<PostDto> selectAllBuyOrNot() throws Exception {
        List<PostDto> postDtoList = postService.selectAllPost(0);
        for (PostDto postDto: postDtoList) {
            int id = postDto.getId();
            UserDto user = userService.selectUserById(postDto.getUser_id());
            postDto.setNickname(user.getNickname());
            postDto.setUp(upDownService.selectUpById(id));
            postDto.setUpCount(upDownService.getUpCount(id));
            postDto.setDown(upDownService.selectDownById(id));
            postDto.setDownCount(upDownService.getDownCount(id));
            postDto.setCommentCount(commentService.getCommentCount(id));
        }
        return postDtoList;
    }

    @GetMapping(value = {"/board/{id}", "/buyornot/{id}"})
    public PostDto selectBoardById(@PathVariable int id) throws Exception {
        PostDto postDto = postService.selectPostById(id);
        UserDto user = userService.selectUserById(postDto.getUser_id());
        postDto.setNickname(user.getNickname());
        postDto.setUp(upDownService.selectUpById(id));
        postDto.setUpCount(upDownService.getUpCount(id));
        postDto.setDown(upDownService.selectDownById(id));
        postDto.setDownCount(upDownService.getDownCount(id));
        postDto.setCommentCount(commentService.getCommentCount(id));
        List<CommentDto> comment = commentService.selectAll(id);
        for (CommentDto commentDto : comment) {
            commentDto.setNickname(userService.selectUserById(commentDto.getUser_id()).getNickname());
        }
        postDto.setComment(comment);
        return postDto;
    }

    @PostMapping("/board")
    public List<PostDto> insertBoard(@RequestBody PostDto post){
    	System.out.println("게시판");
        post.setBoard_category(1);
        postService.insertPost(post);
        return postService.selectAllPost(1);
    }

    @PostMapping("/buyornot")
    public List<PostDto> insertBuyOrNot(@RequestBody PostDto post){
        post.setBoard_category(0);
        postService.insertPost(post);
        return postService.selectAllPost(0);
    }

    @PutMapping(value = {"/board/{id}", "/buyornot/{id}"})
    public PostDto updatePost(@PathVariable int id, @RequestBody PostDto post){
        postService.updatePost(id, post);
        return postService.selectPostById(id);
    }

    @DeleteMapping("/board/{id}")
    public List<PostDto> deleteBoard(@PathVariable int id) {
        postService.deletePost(id);
        return postService.selectAllPost(1);
    }

    @DeleteMapping("/buyornot/{id}")
    public List<PostDto> deleteBuyOrNot(@PathVariable int id) {
        postService.deletePost(id);
        return postService.selectAllPost(0);
    }
}
