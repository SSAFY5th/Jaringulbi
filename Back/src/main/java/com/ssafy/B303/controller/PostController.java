package com.ssafy.B303.controller;

import com.ssafy.B303.model.dto.PostDto;
import com.ssafy.B303.model.service.PostServiceImpl;
import com.ssafy.B303.model.service.UpDownServiceImpl;
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

    @GetMapping("/board")
    public List<PostDto> selectAllPost(){
        return postService.selectAllPost(1).stream().map(postDto -> {
            postDto.setUp(upDownService.selectUpById(postDto.getId()));
            postDto.setUpCount(upDownService.getUpCount(postDto.getId()));
            return postDto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/buyornot")
    public List<PostDto> selectAllBuyOrNot(){
        return postService.selectAllPost(0).stream().map(postDto -> {
            int id = postDto.getId();
            postDto.setUp(upDownService.selectUpById(id));
            postDto.setUpCount(upDownService.getUpCount(id));
            postDto.setDown(upDownService.selectDownById(id));
            postDto.setDownCount(upDownService.getDownCount(id));
            return postDto;
        }).collect(Collectors.toList());
    }

    @GetMapping(value = {"/board/{id}", "/buyornot/{id}"})
    public PostDto selectBoardById(@PathVariable int id){
        return postService.selectPostById(id);
    }

    @PostMapping("/board")
    public List<PostDto> insertBoard(@RequestBody PostDto post){
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
