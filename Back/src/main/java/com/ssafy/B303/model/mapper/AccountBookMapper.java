package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.PostDto;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountBookMapper {
    int insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    List<AccountBookDto> selectMonth(Map<String, Integer> map) throws Exception;
    List<AccountBookDto> selectDay(Map<String, Integer> map) throws Exception;
    void deleteAccountBook(int id) throws Exception;
    void modifyAccountBook(AccountBookDto accountBookDto) throws Exception;
    int monthIncomes(int month, int user_id) throws Exception;
    int monthOutgoings(int month, int user_id) throws Exception;
    Integer dayIncomes(Map<String, Number> map) throws Exception;
    Integer dayOutgoings(Map<String, Number> map) throws Exception;
    void setBudget(@Param("id")int id, @Param("budget")int budget);
}
