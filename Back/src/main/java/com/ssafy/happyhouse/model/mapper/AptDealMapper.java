package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.dto.AptDealDto;
import com.ssafy.happyhouse.model.dto.SearchDto;

public interface AptDealMapper {
	public List<AptDealDto> selectAptDeal() throws SQLException;
	public List<AptDealDto> searchAptDeal(SearchDto searchDto) throws SQLException;
	public String selectDongName(String dongcode) throws SQLException;
}
