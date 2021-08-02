package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AptDealDto;
import com.ssafy.happyhouse.model.dto.SearchDto;

public interface AptDealService {
	public List<AptDealDto> selectAptDeal() throws SQLException;
	public List<AptDealDto> searchAptDeal(SearchDto searchDto) throws SQLException;
}



