package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.UpDownDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpDownMapper {

    // 좋아요 개수
    int getUpCount(int id);

    int getDownCount(int id);

    List<UpDownDto> selectUpById(int id);

    List<UpDownDto> selectDownById(int id);

    void insertUp(UpDownDto up);

    void insertDown(UpDownDto down);

    // 좋아요 취소
    void deleteUp(int id);

    void deleteDown(int id);

}
