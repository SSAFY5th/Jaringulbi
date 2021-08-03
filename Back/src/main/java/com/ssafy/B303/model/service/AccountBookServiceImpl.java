package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.mapper.AccountBookMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@Service
public class AccountBookServiceImpl implements AccountBookService{

    private SqlSession sqlSession;

    @Autowired
    public AccountBookServiceImpl(SqlSession sqlSession) { this.sqlSession = sqlSession; }

    @Override
    public void insertAccountBook(AccountBookDto accountBookDto) throws Exception {
        sqlSession.getMapper(AccountBookMapper.class).insertAccountBook(accountBookDto);
    }

    @Override
    public List<AccountBookDto> selectMonth(String month, int user_id) throws Exception {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("month", month);
        hashMap.put("user_id", user_id);
        return sqlSession.getMapper(AccountBookMapper.class).selectMonth(hashMap);
    }

    @Override
    public List<AccountBookDto> selectDay(String day, int user_id) throws Exception {
        return null;
    }
}
