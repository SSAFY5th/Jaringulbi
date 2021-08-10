package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.dto.EnterChallengeVo;
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

    @Override
    public ChallengeDto getChallenge(int id) {
        return sqlSession.getMapper(ChallengeMapper.class).getChallenge(id);
    }

    @Override
    public int getChallengeUserNum(int id) {
        Integer a = sqlSession.getMapper(ChallengeMapper.class).getChallengeUserNum(id);
        if(a == null) return 0;
        return a;
    }

    @Override
    public void enterChallenge(EnterChallengeVo enterChallengeVo) {
        sqlSession.getMapper(ChallengeMapper.class).enterChallenge(enterChallengeVo);
    }
}
