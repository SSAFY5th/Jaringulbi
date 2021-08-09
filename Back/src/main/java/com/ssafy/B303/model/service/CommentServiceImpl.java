package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.CommentDto;
import com.ssafy.B303.model.dto.PostDto;
import com.ssafy.B303.model.mapper.CommentMapper;
import com.ssafy.B303.model.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDto> selectAll(int post_id) {
        return commentMapper.selectAll(post_id);
    }

    @Override
    public CommentDto selectCommentById(int id) {
        return commentMapper.selectById(id);
    }

    @Override
    public int getCommentCount(int post_id) {
        return commentMapper.getCommentCount(post_id);
    }

    @Override
    public void insertComment(CommentDto comment) {
        commentMapper.insert(comment);
    }

    @Override
    public void updateComment(int id, CommentDto comment) {
        CommentDto commentDto = commentMapper.selectById(id);
        if(commentDto!=null){
            commentDto.setContents(comment.getContents() != null ? comment.getContents() : commentDto.getContents());
            commentMapper.update(commentDto);
        } else {
            throw new IllegalStateException("게시글이 존재하지 않습니다");
        }
    }

    @Override
    public void deleteComment(int id) {
        commentMapper.delete(id);
    }
}
