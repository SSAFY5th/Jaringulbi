package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import com.ssafy.happyhouse.model.dto.MemberDto;

public interface MemberMapper {
	
	public MemberDto selectMember(String userId) throws Exception;
	public int insertMember(MemberDto memberDto);
	public int updateMember(MemberDto memberDto) throws Exception;
	public int deleteMember(MemberDto memberDto) throws Exception;
	public MemberDto login(Map<String, String> map) throws Exception;
}
