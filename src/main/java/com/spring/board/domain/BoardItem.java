package com.spring.board.domain;

import java.util.Date;

public class BoardItem {
	private Long ID;
	private String title;
	private String text;
	private Long viewCnt;
	private String editer;
	private String passwd;
	private Date date;
	
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "BoardItem [ID=" + ID + ", title=" + title + ", text=" + text + ", viewCnt=" + viewCnt + ", editer="
				+ editer + ", passwd=" + passwd + ", date=" + date + "]";
	}
}
