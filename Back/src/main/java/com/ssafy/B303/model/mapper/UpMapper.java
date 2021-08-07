package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.UpDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UpMapper {

    // 좋아요 개수
    int getCount(int id);

    List<UpDto> selectUpById(int id);

    void insert(UpDto up);

    // 좋아요 취소
    void delete(UpDto up);

}
