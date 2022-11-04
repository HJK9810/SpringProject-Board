package com.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.board.domain.Pagination;
import com.spring.board.mapper.BoardMapper;

@Repository
public class PaginationServiceImpl implements PaginationService {

	@Autowired
	BoardMapper mapper;

	@Override
	public Pagination getPagination(int nowPage, int PageSize) {
		Pagination pagination = new Pagination();

		pagination.setNumber(nowPage);
		pagination.setPageSize(PageSize);
		pagination.setFist(false);
		pagination.setLast(false);

		pagination.setTotalPage(mapper.totalSize() / PageSize);
		
		if(nowPage == 0) pagination.setFist(true);
		if(nowPage == pagination.getTotalPage()) pagination.setLast(true);
		
		Long itemID = (long) (nowPage * PageSize);
		
		pagination.setStartItemID(itemID);

		return pagination;
	}
}
