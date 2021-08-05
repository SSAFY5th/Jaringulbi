package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> selectAllPost(int board_category);

    PostDto selectPostById(int id);

    void insertPost(PostDto post);

    void updatePost(int id, PostDto post);

    void deletePost(int id);
}
