package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.UserDto;
import com.ssafy.B303.model.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private SqlSession sqlSession;

	@Autowired
	public UserServiceImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public UserDto selectUser(String login_id) throws Exception {
		return sqlSession.getMapper(UserMapper.class).selectUser(login_id);
	}

    @Override
    public UserDto selectUserById(int id) throws Exception {
        return sqlSession.getMapper(UserMapper.class).selectUserById(id);
    }

	@Override
	public void insertUser(UserDto userDto) throws Exception {
		sqlSession.getMapper(UserMapper.class).insertUser(userDto);
	}

	@Override
	public void updateUser(UserDto userDto) throws Exception {
		sqlSession.getMapper(UserMapper.class).updateUser(userDto);
	}

	@Override
	public void deleteUser(String login_id) throws Exception {
		sqlSession.getMapper(UserMapper.class).deleteUser(login_id);
	}

	@Override
	public UserDto login(Map<String, String> map) throws Exception {
		if (map.get("login_id") == null || map.get("password") == null)
			return null;
		return sqlSession.getMapper(UserMapper.class).login(map);
	}
}