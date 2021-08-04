package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.PostDto;
import com.ssafy.B303.model.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostDto> selectAllPost(int board_category) {
        return postMapper.selectAll(board_category);
    }

    @Override
    public PostDto selectPostById(int id) {
        return postMapper.selectById(id);
    }

    @Override
    public void insertPost(PostDto post) {
        postMapper.insert(post);
    }

    @Override
    public void updatePost(int id, PostDto updatePost) {
        PostDto post = postMapper.selectById(id);
        if(post!=null){
            post.setTitle(updatePost.getTitle() != null ? updatePost.getTitle() : post.getTitle());
            post.setContents(updatePost.getContents() != null ? updatePost.getContents() : post.getContents());
            post.setPrice(updatePost.getPrice() != null ? updatePost.getPrice() : post.getPrice());
            post.setImage(updatePost.getImage() != null ? updatePost.getImage() : post.getImage());
            post.setChallenge_id(updatePost.getChallenge_id() != null ? updatePost.getChallenge_id() : post.getChallenge_id());
            postMapper.update(post);
        } else {
            throw new IllegalStateException("게시글이 존재하지 않습니다");
        }
    }

    @Override
    public void deletePost(int id) {
        if(postMapper.selectById(id)!=null){
            postMapper.delete(id);
        } else {
            throw new IllegalStateException("게시글이 존재하지 않습니다");
        }
    }
}
