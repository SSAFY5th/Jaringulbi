package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.mapper.ChallengeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService{

    private SqlSession sqlSession;

    public ChallengeServiceImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ChallengeDto> getChallengeList() {
        return sqlSession.getMapper(ChallengeMapper.class).getChallengeList();
    }
}
