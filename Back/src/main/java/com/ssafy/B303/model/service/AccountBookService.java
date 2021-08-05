package com.ssafy.B303.model.service;


import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface AccountBookService {

    public void insertAccountBook(AccountBookDto accountBookDto) throws Exception;
    public List<AccountBookDto> selectMonth(String month, int user_id) throws Exception;
    public List<AccountBookDto> selectDay(String day, int user_id) throws Exception;

}
