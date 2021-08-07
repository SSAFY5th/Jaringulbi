package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.UpDto;

import java.util.List;

public interface UpService {
    int getUpCount(int post_id);
    List<UpDto> selectUpById(int post_id);
    void insertUp(UpDto up);
    void deleteUp(UpDto up);
}
