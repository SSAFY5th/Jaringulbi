package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.CommentDto;
import com.ssafy.B303.model.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<CommentDto> selectAll(int post_id);
    CommentDto selectById(int id);
    int getCommentCount(int post_id);
    void insert(CommentDto comment);
    void update(CommentDto comment);
    void delete(int id);
}
