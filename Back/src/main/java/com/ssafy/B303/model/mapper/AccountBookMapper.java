package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.AccountBookDto;

import java.util.HashMap;
import java.util.List;

public interface AccountBookMapper {
    int insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    List<AccountBookDto> selectMonth(HashMap<String, Object> hashMap) throws Exception;
    List<AccountBookDto> selectDay(HashMap<String, Object>hashMap) throws Exception;
}
