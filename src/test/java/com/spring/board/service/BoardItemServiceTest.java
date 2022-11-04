package com.spring.board.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring.board.domain.BoardItem;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardItemServiceTest {
	
	@Autowired
	private BoardItemService service;

	@Test
	public void onePageTest() {
		BoardItem item = service.oneView(1L);
		
		assertEquals(item.getID().intValue(), 1L);
		assertEquals(item.getText(), "mapper test");
		assertEquals(item.getTitle(), "mapper test");
		assertEquals(item.getEditer(), "mapper test");
		assertEquals(item.getPasswd(), "mapper test");
	}

}
