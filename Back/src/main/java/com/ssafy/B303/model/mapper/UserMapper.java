package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.UserDto;

import java.util.Map;

public interface UserMapper {
    public UserDto selectUser(String login_id) throws Exception;
    public UserDto selectUserById(int id) throws Exception;
    public int insertUser(UserDto userDto);
    public int updateUser(UserDto userDto) throws Exception;
    public int deleteUser(UserDto userDto) throws Exception;
    public UserDto login(Map<String, String> map) throws Exception;
}
