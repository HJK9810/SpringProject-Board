package com.spring.board.mapper;

import java.util.List;

import com.spring.board.domain.BoardItem;

public interface BoardMapper {
	
	public void dataInput(BoardItem item);
	public BoardItem viewOne(Long id); 
	public List<BoardItem> onePage();
	public int editOne(BoardItem item);
	public int deleteOne(Long id);
	
	public int totalCount();
}
