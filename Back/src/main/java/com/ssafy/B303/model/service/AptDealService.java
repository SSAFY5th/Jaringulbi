package com.ssafy.B303.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.B303.model.dto.AptDealDto;
import com.ssafy.B303.model.dto.SearchDto;

public interface AptDealService {
	public List<AptDealDto> selectAptDeal() throws SQLException;
	public List<AptDealDto> searchAptDeal(SearchDto searchDto) throws SQLException;
}



