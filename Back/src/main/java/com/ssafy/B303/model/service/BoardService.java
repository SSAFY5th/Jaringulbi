package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.BoardDto;

import java.util.List;

public interface BoardService {
    List<BoardDto> selectAllBoards();

    void selectBoardById(int id);

    void insertBoard(BoardDto board);

    void updateBoard(int id, BoardDto bard);

    void deleteBoard(int id);
}
