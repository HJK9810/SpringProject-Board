package com.spring.board.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.BoardItem;
import com.spring.board.domain.Pagination;
import com.spring.board.mapper.BoardMapper;

@Repository
public class BoardItemServiceImpl implements BoardItemService {

	@Autowired
	private BoardMapper mapper;
	@Autowired
	private PaginationService paginationService;

	@Override
	public BoardItem oneView(Long id) {
		BoardItem item = mapper.viewOne(id);
		item.setViewCnt(item.getViewCnt() + 1);
		mapper.editOne(item);
		return item;
	}

	@Override
	public void addItem(BoardItem item) {
		Date date = new Date();
		item.setDate(date);
		mapper.dataInput(item);
	}

	@Override
	public BoardItem editView(Long id) {
		BoardItem item = mapper.viewOne(id);
		item.setViewCnt(item.getViewCnt() - 1);
		mapper.editOne(item);
		return item;
	}

	@Override
	public void editItem(BoardItem item) {
		mapper.editOne(item);
	}

	@Override
	public int deleteItem(Long id) {
		return mapper.deleteOne(id);
	}

	@Override
	public List<BoardItem> onePage(int nowPage, int pageSize) {
		// nowPage : 현 페이지, pageSize : 한 페이지당 아이템수
		int totaSize = mapper.totalSize();
		Pagination page = paginationService.getPagination(nowPage, pageSize, totaSize);

		return mapper.onePage(page);
	}

}
