package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.NoticeDto;

public interface NoticeMapper {
	public List<NoticeDto> selectNotice() throws SQLException;
	public void insertNotice(NoticeDto noticeDto);
	public void updateNotice(NoticeDto noticeDto);
	public void deleteNotice(int no);
	public NoticeDto searchNotice(int articleNo) throws SQLException;
	public void increaseViewCnt(int articleNo) throws SQLException;
}
