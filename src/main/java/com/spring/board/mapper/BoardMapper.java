package com.spring.board.mapper;

import com.spring.board.domain.BoardItem;

public interface BoardMapper {
	
	public void dataInput(BoardItem item);
	public BoardItem viewOne(Long id); 
}
