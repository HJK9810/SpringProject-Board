package com.spring.board.service;

import org.springframework.stereotype.Service;

import com.spring.board.domain.Pagination;

@Service
public interface PaginationService {
	
	Pagination getPagination(int nowPage, int PageSize, int totalItems);
}
