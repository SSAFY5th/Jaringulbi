package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.mapper.AccountBookMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountBookServiceImpl implements AccountBookService{
    private static final Logger logger = LoggerFactory.getLogger(AccountBookServiceImpl.class);

    private SqlSession sqlSession;

    @Autowired
    public AccountBookServiceImpl(SqlSession sqlSession) { this.sqlSession = sqlSession; }

    @Override
    public void insertAccountBook(AccountBookDto accountBookDto) throws Exception {
        sqlSession.getMapper(AccountBookMapper.class).insertAccountBook(accountBookDto);
    }

    @Override
    public List<AccountBookDto> selectMonth(int month, int user_id) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("month", month);
        map.put("user_id", user_id);
        return sqlSession.getMapper(AccountBookMapper.class).selectMonth(map);
    }

    @Override
    public List<AccountBookDto> selectDay(int month, int day, int user_id) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        map.put("month", month);
        map.put("day", day);
        map.put("user_id", user_id);
        return sqlSession.getMapper(AccountBookMapper.class).selectDay(map);
    }

    @Override
    public void deleteAccountBook(int id) throws Exception {
        sqlSession.getMapper(AccountBookMapper.class).deleteAccountBook(id);
    }

    @Override
    public void modifyAccountBook(AccountBookDto accountBookDto) throws Exception {
        sqlSession.getMapper(AccountBookMapper.class).modifyAccountBook(accountBookDto);
    }

    @Override
    public int monthIncomes(int month) throws Exception {
        return sqlSession.getMapper(AccountBookMapper.class).monthIncomes(month);
    }

    @Override
    public int monthOutgoings(int month) throws Exception {
        return sqlSession.getMapper(AccountBookMapper.class).monthOutgoings(month);
    }
}
