package com.ssafy.B303.model.service;


import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface AccountBookService {

    void insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    List<AccountBookDto> selectMonth(int month, int user_id) throws Exception;
    List<AccountBookDto> selectDay(int month, int day, int user_id) throws Exception;
    void deleteAccountBook(int id) throws Exception;
    void modifyAccountBook(AccountBookDto accountBookDto) throws Exception;
    int monthIncomes(int month, int user_id) throws Exception;
    int monthOutgoings(int month, int user_id) throws Exception;
    List<Number> dayIncomes(int month, int user_id) throws Exception;
    List<Number> dayOutgoings(int month, int user_id) throws Exception;
}
