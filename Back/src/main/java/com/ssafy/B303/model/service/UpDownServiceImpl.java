package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.UpDownDto;
import com.ssafy.B303.model.mapper.UpDownMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpDownServiceImpl implements UpDownService {

    @Autowired
    private UpDownMapper upDownMapper;

    @Override
    public int getUpCount(int post_id) {
        return upDownMapper.getUpCount(post_id);
    }

    @Override
    public int getDownCount(int post_id) {
        return upDownMapper.getDownCount(post_id);
    }

    @Override
    public List<UpDownDto> selectUpById(int post_id) {
        return upDownMapper.selectUpById(post_id);
    }

    @Override
    public List<UpDownDto> selectDownById(int post_id) {
        return upDownMapper.selectDownById(post_id);
    }

    @Override
    public void insertUp(UpDownDto up) {
        upDownMapper.insertUp(up);
    }

    @Override
    public void insertDown(UpDownDto down) {
        upDownMapper.insertDown(down);
    }

    @Override
    public void deleteUp(int id) {
        upDownMapper.deleteUp(id);
    }

    @Override
    public void deleteDown(int id) {
        upDownMapper.deleteDown(id);
    }
}
