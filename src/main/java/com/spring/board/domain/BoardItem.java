package com.spring.board.domain;

public class BoardItem {
	private Long ID;
	private String title;
	private String text;
	private Long viewCnt;
	private String editer;
	private String passwd;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(Long viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getEditer() {
		return editer;
	}
	public void setEditer(String editer) {
		this.editer = editer;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
}
