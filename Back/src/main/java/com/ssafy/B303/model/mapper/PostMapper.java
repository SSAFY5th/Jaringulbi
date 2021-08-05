package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {

    List<PostDto> selectAll(int board_category);
    PostDto selectById(int id);

    void insert(PostDto post);
    void update(PostDto post);
    void delete(int id);

}
