package com.ssafy.B303.model.dto;

public class SearchDto {
	private int pageNo;
	private String dongcode;
	private String dongname;
	private int pageCount;
	
	public int getPageNo() {
		return pageNo;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongname(String dongname) {
		this.dongname = dongname;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
