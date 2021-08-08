package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.CommentDto;
import com.ssafy.B303.model.dto.PostDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> selectAll(int post_id);

    int getCommentCount(int post_id);

    CommentDto selectCommentById(int id);

    void insertComment(CommentDto comment);

    void updateComment(int id, CommentDto comment);

    void deleteComment(int id);
}
