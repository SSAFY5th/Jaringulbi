package com.ssafy.B303.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.B303.model.dto.NoticeDto;

public interface NoticeService {
	public List<NoticeDto> selectNotice() throws SQLException;
	public void insertNotice(NoticeDto noticeDto);
	public void updateNotice(NoticeDto noticeDto);
	public void deleteNotice(int no);
	public NoticeDto searchNotice(int articleNo) throws SQLException;
}

