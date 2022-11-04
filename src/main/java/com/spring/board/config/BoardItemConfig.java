package com.spring.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.board.service.BoardItemService;
import com.spring.board.service.BoardItemServiceImpl;
import com.spring.board.service.PaginationService;
import com.spring.board.service.PaginationServiceImpl;
import com.spring.board.web.BoardItemController;

@Configuration
public class BoardItemConfig {
	@Bean
	public BoardItemService boardItemService() {
		return new BoardItemServiceImpl();
	}
	
	@Bean
	public BoardItemController boardItemController() {
		return new BoardItemController();
	}
	
	@Bean
	public PaginationService paginationService() {
		return new PaginationServiceImpl();
	}
}
