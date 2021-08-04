package com.ssafy.B303.controller;

import com.ssafy.B303.model.dto.BoardDto;
import com.ssafy.B303.model.service.BoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardServiceImpl boardService;

    @GetMapping("/board")
    public List<BoardDto> selectAllBoards(){
        return boardService.selectAllBoards();
    }

    @PostMapping("/board")
    public List<BoardDto> insertBoard(@RequestBody BoardDto board){
        boardService.insertBoard(board);
        return boardService.selectAllBoards();
    }

    @PutMapping("/board/{id}")
    public List<BoardDto> updateBoard(@PathVariable int id, @RequestBody BoardDto board){
        boardService.updateBoard(id, board);
        return boardService.selectAllBoards();
    }

    @DeleteMapping("/board/{id")
    public List<BoardDto> deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
        return boardService.selectAllBoards();
    }
}
