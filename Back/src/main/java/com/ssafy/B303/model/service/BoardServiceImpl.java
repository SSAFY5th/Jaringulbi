package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.BoardDto;
import com.ssafy.B303.model.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectAllBoards() {
        return boardMapper.selectAll();
    }

    @Override
    public BoardDto selectBoardById(int id) {
        return boardMapper.selectById(id);
    }

    @Override
    public void insertBoard(BoardDto board) {
        boardMapper.insert(board);
    }

    @Override
    public void updateBoard(int id, BoardDto updateBoard) {
        BoardDto board = boardMapper.selectById(id);
        if(board!=null){
            board.setTitle(updateBoard.getTitle());
            board.setContents(updateBoard.getContents());
            boardMapper.update(board);
        } else {
            throw new IllegalStateException("게시글이 존재하지 않습니다");
        }
    }

    @Override
    public void deleteBoard(int id) {
        if(boardMapper.selectById(id)!=null){
            boardMapper.delete(id);
        } else {
            throw new IllegalStateException("게시글이 존재하지 않습니다");
        }
    }
}
