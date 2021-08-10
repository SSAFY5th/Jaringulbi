package com.ssafy.B303.model.service;


import com.ssafy.B303.model.dto.UserDto;

import java.util.Map;

public interface UserService {

    public UserDto selectUser(String login_id) throws Exception;

    public UserDto selectUserById(int id) throws Exception;

    public void insertUser(UserDto userDto) throws Exception;

    public void updateUser(UserDto userDto) throws Exception;

    public void deleteUser(String login_id) throws Exception;

    public UserDto login(Map<String, String> map) throws Exception;
}
