package com.ssafy.B303.model.service;


import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface AccountBookService {

    public void insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    public List<AccountBookDto> selectMonth(int month, int user_id) throws Exception;
    public List<AccountBookDto> selectDay(int month, int day, int user_id) throws Exception;
    public void deleteAccountBook(int id) throws Exception;
    public void modifyAccountBook(AccountBookDto accountBookDto) throws Exception;
    public int monthIncomes(int month) throws Exception;
    public int monthOutgoings(int month) throws Exception;
    public List<Number> dayIncomes(int month) throws Exception;
    public List<Number> dayOutgoings(int month) throws Exception;
}
