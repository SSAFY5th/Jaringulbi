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
import java.util.LinkedList;
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
    public Integer monthIncomes(int month, int user_id) throws Exception {
        return sqlSession.getMapper(AccountBookMapper.class).monthIncomes(month, user_id);
    }

    @Override
    public Integer monthOutgoings(int month, int user_id) throws Exception {
        return sqlSession.getMapper(AccountBookMapper.class).monthOutgoings(month, user_id);
    }

    @Override
    public List<Number> dayIncomes(int month, int user_id) throws Exception {
        List<Number> incomes = new LinkedList<>();

        for(int i = 1; i <= 31; i++){
            Map<String, Number> map = new HashMap<>();
            map.put("month", month);
            map.put("day", i);
            map.put("user_id", user_id);
            incomes.add(sqlSession.getMapper(AccountBookMapper.class).dayIncomes(map));
        }

        return incomes;
    }

    @Override
    public List<Number> dayOutgoings(int month, int user_id) throws Exception {
        List<Number> outgoings = new LinkedList<>();
        for(int i = 1; i <= 31; i++){
            Map<String, Number> map = new HashMap<>();
            map.put("month", month);
            map.put("day", i);
            map.put("user_id", user_id);
            outgoings.add(sqlSession.getMapper(AccountBookMapper.class).dayOutgoings(map));
        }
        return outgoings;
    }

    @Override
    public void setBudget(int id, int budget) {
        sqlSession.getMapper(AccountBookMapper.class).setBudget(id ,budget);
    }


}
