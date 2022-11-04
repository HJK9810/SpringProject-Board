package com.spring.board.domain;

public class Pagination {
	private int number; // 현 페이지 번호(0~)
	private int pageSize; // 한 페이지당 아이템수
	private int totalPage; // 총 페이지수
	private Long startItemID; // 현 페이지 시작 아이템 ID
	private boolean fist; // 첫페이지인가?
	private boolean last; // 마지막 페이지인가?
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Long getStartItemID() {
		return startItemID;
	}
	public void setStartItemID(Long startItemID) {
		this.startItemID = startItemID;
	}
	public boolean isFist() {
		return fist;
	}
	public void setFist(boolean fist) {
		this.fist = fist;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
}
