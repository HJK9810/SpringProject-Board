package com.spring.board.service;

import com.spring.board.domain.Pagination;

public interface PaginationService {
	
	Pagination getPagination(int nowPage, int PageSize, int totalItems);
}
