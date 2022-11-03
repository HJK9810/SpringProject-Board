package com.spring.board.service;

import java.util.List;

import com.spring.board.domain.BoardItem;

public interface BoardItemService {
	
	List<BoardItem> onePage(int nowPage, int pageSize);
	
	BoardItem oneView(Long id);
	void addItem(BoardItem item);
	BoardItem editView(Long id);
	void editItem(BoardItem item);
	int deleteItem(Long id);
}
