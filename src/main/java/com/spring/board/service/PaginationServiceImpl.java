package com.spring.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.domain.Pagination;
import com.spring.board.mapper.BoardMapper;

@Service
public class PaginationServiceImpl implements PaginationService {

	@Autowired
	BoardMapper mapper;

	@Override
	public Pagination getPagination(int nowPage, int PageSize, int totalItems) {
		Pagination pagination = new Pagination();

		pagination.setNumber(nowPage);
		pagination.setPageSize(PageSize);
		pagination.setFist(false);
		pagination.setLast(false);

		pagination.setTotalPage(totalItems / PageSize + 1);
		
		if(nowPage == 0) pagination.setFist(true);
		if(nowPage == pagination.getTotalPage()) pagination.setLast(true);
		
		Long itemID = (long) (nowPage * PageSize + 1);
		
		pagination.setStartItemID(itemID);

		return pagination;
	}

}
