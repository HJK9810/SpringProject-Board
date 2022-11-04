package com.spring.board.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.board.domain.Pagination;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PaginationServiceTest {
	
	@Autowired
	PaginationService paginationService;
	
	@Test
	public void PaginationTest() {
		Pagination page = paginationService.getPagination(0, 10, 5);
		
		assertEquals(page.getTotalPage(), 1);
		assertEquals(page.isFist(), true);
		assertEquals(page.isLast(), false);
		assertEquals(page.getPageSize(), 10);
		assertEquals(page.getNumber(), 0);
		assertEquals((long) page.getStartItemID(), 1L);
	}
	
	@Test
	public void PaginationTest2() {
		Pagination page = paginationService.getPagination(6, 10, 157);
		
		assertEquals(page.getTotalPage(), 16);
		assertEquals(page.isFist(), false);
		assertEquals(page.isLast(), false);
		assertEquals(page.getPageSize(), 10);
		assertEquals(page.getNumber(), 6);
		assertEquals((long) page.getStartItemID(), 61L);
	}
}
