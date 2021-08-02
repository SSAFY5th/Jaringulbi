package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {
	private static final Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<NoticeDto> selectNotice() throws SQLException {
		return sqlSession.getMapper(NoticeMapper.class).selectNotice();
	}

	@Override
	public void insertNotice(NoticeDto noticeDto) {
		sqlSession.getMapper(NoticeMapper.class).insertNotice(noticeDto);
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) {
		sqlSession.getMapper(NoticeMapper.class).updateNotice(noticeDto);
	}

	@Override
	public void deleteNotice(int no) {
		sqlSession.getMapper(NoticeMapper.class).deleteNotice(no);
	}

	@Override
	public NoticeDto searchNotice(int articleNo) throws SQLException {
		sqlSession.getMapper(NoticeMapper.class).increaseViewCnt(articleNo);
		return sqlSession.getMapper(NoticeMapper.class).searchNotice(articleNo);
	}
}
