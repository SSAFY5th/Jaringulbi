package com.ssafy.B303.model.service;


import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface AccountBookService {

    public AccountBookDto insertAccountBook() throws SQLException;
    public List<AccountBookDto> selectMonth() throws SQLException;
    public List<AccountBookDto> selectDay() throws SQLException;

}
