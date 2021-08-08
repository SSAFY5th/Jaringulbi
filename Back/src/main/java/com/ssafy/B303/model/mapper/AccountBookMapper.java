package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.AccountBookDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AccountBookMapper {
    int insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    List<AccountBookDto> selectMonth(Map<String, Integer> map) throws Exception;
    List<AccountBookDto> selectDay(Map<String, Integer> map) throws Exception;
    void deleteAccountBook(int id) throws Exception;
    void modifyAccountBook(AccountBookDto accountBookDto) throws Exception;
    int monthIncomes(int month) throws Exception;
    int monthOutgoings(int month) throws Exception;
    Integer dayIncomes(Map<String, Number> map) throws Exception;
    Integer dayOutgoings(Map<String, Number> map) throws Exception;
}
