package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectAll();
    void selectById(int id);

    void insert(BoardDto board);
    void update(BoardDto board);
    void delete(int id);

}
