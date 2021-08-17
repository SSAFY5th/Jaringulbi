package com.ssafy.B303.controller;

import com.ssafy.B303.model.dto.UpDownDto;
import com.ssafy.B303.model.service.PostServiceImpl;
import com.ssafy.B303.model.service.UpDownServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
public class UpDownController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UpDownServiceImpl upDownService;


    @PostMapping("/up")
    public void insertUp(@RequestBody UpDownDto up){
        if (isSelected(up)) return;
        upDownService.insertUp(up);
    }

    @PostMapping("/down")
    public void insertDown(@RequestBody UpDownDto down){
        if (postService.selectPostById(down.getPost_id()).getBoard_category() == 1) return;
        else if (isSelected(down)) return;
        upDownService.insertDown(down);
    }

    @DeleteMapping("/up/{id}")
    public void deleteUp(@PathVariable int id){
        upDownService.deleteUp(id);
    }

    @DeleteMapping("/down/{id}")
    public void deleteDown(@PathVariable int id){
        upDownService.deleteDown(id);
    }


    private boolean isSelected(UpDownDto upDownDto) { // Up, Down 둘중에 하나라도 선택되어있으면 true 반환
        return upDownService.selectUpById(upDownDto.getPost_id())
                .stream()
                .anyMatch(upDto -> upDto.getUser_id() == upDownDto.getUser_id())//user_id같은게 있으면 true
                ||
                upDownService.selectDownById(upDownDto.getPost_id())
                        .stream()
                        .anyMatch(downDto -> downDto.getUser_id() == upDownDto.getUser_id());

    }
}
