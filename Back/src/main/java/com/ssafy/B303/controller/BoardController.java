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

    @GetMapping("/board/{id}")
    public BoardDto selectBoardById(@PathVariable int id){
        return boardService.selectBoardById(id);
    }

    @PostMapping("/board")
    public List<BoardDto> insertBoard(@RequestBody BoardDto board){
        boardService.insertBoard(board);
        return boardService.selectAllBoards();
    }

    @PutMapping("/board/{id}")
    public BoardDto updateBoard(@PathVariable int id, @RequestBody BoardDto board){
        boardService.updateBoard(id, board);
        return boardService.selectBoardById(id);
    }

    @DeleteMapping("/board/{id}")
    public List<BoardDto> deleteBoard(@PathVariable int id) {
        boardService.deleteBoard(id);
        return boardService.selectAllBoards();
    }
}
