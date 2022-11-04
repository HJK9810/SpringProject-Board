package com.spring.board.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.board.domain.BoardItem;
import com.spring.board.domain.Pagination;
import com.spring.board.service.PaginationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
     
     @Autowired
     private BoardMapper mapper;
     @Autowired
     private PaginationService paginationService;
 
//     @Test
//     public void testEnroll() {
//         
//         BoardItem item = new BoardItem();
//         Date date = new Date();
//         
//         item.setTitle("mapper test");
//         item.setText("mapper test");
//         item.setEditer("mapper test");
//         item.setDate(date);
//         item.setPasswd("mapper test");
//         
//         mapper.dataInput(item);
//     }
     
//     @Test
//     public void viewOneTest() {
//    	 BoardItem item = mapper.viewOne(1L);
//    	 System.out.println(item.toString());
//     }
     
//     @Test
//     public void updateTest() {
//    	 BoardItem item = new BoardItem();
//    	 item.setText("update test");
//    	 item.setTitle("update Test");
//    	 item.setID(1L);
//    	 int result = mapper.editOne(item);
//    	 
//    	 assertEquals(result, 1);
//     }
     
//     @Test
//     public void deleteTest() {
//    	 int result = mapper.deleteOne(3L); // delete ID
//    	 assertEquals(result, 1);
//     }
     
//     @Test
//     public void countTest() {
//    	 assertEquals(mapper.totalCount(), 3);
//     }
     
     @Test
     public void ListTest() {
    	 Pagination page = paginationService.getPagination(0, 10, mapper.totalCount());
    	 
    	 List<BoardItem> list = mapper.onePage(page);
    	 for(BoardItem item : list) {
    		 System.out.println(item.toString());
    	 }
     }
}
