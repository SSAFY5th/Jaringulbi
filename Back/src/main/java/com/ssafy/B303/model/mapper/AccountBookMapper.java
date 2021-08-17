package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.PostDto;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AccountBookMapper {
    int insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    List<AccountBookDto> selectMonth(Map<String, Integer> map) throws Exception;
    List<AccountBookDto> selectDay(Map<String, Integer> map) throws Exception;
    void deleteAccountBook(int id) throws Exception;
    void modifyAccountBook(AccountBookDto accountBookDto) throws Exception;
    Integer monthIncomes(@Param("month") int month, @Param("user_id") int user_id) throws Exception;
    Integer monthOutgoings(@Param("month") int month, @Param("user_id") int user_id) throws Exception;
    Integer dayIncomes(Map<String, Number> map) throws Exception;
    Integer dayOutgoings(Map<String, Number> map) throws Exception;
    void setBudget(@Param("id")int id, @Param("budget")int budget);
}
