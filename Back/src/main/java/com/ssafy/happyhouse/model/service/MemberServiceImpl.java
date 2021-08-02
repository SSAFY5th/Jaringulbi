package com.ssafy.happyhouse.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.MemberDto;
import com.ssafy.happyhouse.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto selectMember(String userId) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).selectMember(userId);
	}

	@Override
	public void insertMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).insertMember(memberDto);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).updateMember(memberDto);
	}

	@Override
	public void deleteMember(MemberDto memberDto) throws Exception {
		sqlSession.getMapper(MemberMapper.class).deleteMember(memberDto);
	}

	@Override
	public MemberDto login(Map<String, String> map) throws Exception {
		if(map.get("userid") == null || map.get("passwd") == null)
			return null;
		return sqlSession.getMapper(MemberMapper.class).login(map);
	}
}
