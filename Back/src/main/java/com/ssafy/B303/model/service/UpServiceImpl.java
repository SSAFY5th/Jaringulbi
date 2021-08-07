package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.UpDto;
import com.ssafy.B303.model.mapper.UpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpServiceImpl implements UpService {

    @Autowired
    private UpMapper upMapper;

    @Override
    public int getUpCount(int post_id) {
        return upMapper.getCount(post_id);
    }

    @Override
    public List<UpDto> selectUpById(int post_id) {
        return upMapper.selectUpById(post_id);
    }

    @Override
    public void insertUp(UpDto up) {
        upMapper.insert(up);
    }

    @Override
    public void deleteUp(UpDto up) {
        upMapper.delete(up);
    }
}
