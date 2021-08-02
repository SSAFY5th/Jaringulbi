package com.ssafy.B303.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.B303.model.dto.AptDealDto;
import com.ssafy.B303.model.dto.SearchDto;
import com.ssafy.B303.model.mapper.AptDealMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AptDealServiceImpl implements AptDealService {
	private static final Logger logger = LoggerFactory.getLogger(AptDealServiceImpl.class);

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<AptDealDto> selectAptDeal() throws SQLException {
		return sqlSession.getMapper(AptDealMapper.class).selectAptDeal();
	}

	@Override
	public List<AptDealDto> searchAptDeal(SearchDto searchDto) throws SQLException {
		// 동 코드로 동이름 가져오기
		String dongName = sqlSession.getMapper(AptDealMapper.class).selectDongName(searchDto.getDongcode());
		searchDto.setDongname(dongName);
		// 동 이름으로 검색
		searchDto.setPageCount((searchDto.getPageNo()-1)*9);
		return sqlSession.getMapper(AptDealMapper.class).searchAptDeal(searchDto);
	}

}
