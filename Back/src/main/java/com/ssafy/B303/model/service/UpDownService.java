package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.UpDownDto;

import java.util.List;

public interface UpDownService {
    int getUpCount(int post_id);
    int getDownCount(int post_id);
    List<UpDownDto> selectUpById(int post_id);
    List<UpDownDto> selectDownById(int post_id);
    void insertUp(UpDownDto up);
    void insertDown(UpDownDto down);
    void deleteUp(UpDownDto up);
    void deleteDown(UpDownDto down);

}
