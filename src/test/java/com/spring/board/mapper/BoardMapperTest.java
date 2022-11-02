package com.spring.board.mapper;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.board.domain.BoardItem;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {
     
     @Autowired
     private BoardMapper mapper;
 
     @Test
     public void testEnroll() {
         
         BoardItem item = new BoardItem();
         Date date = new Date();
         
         item.setTitle("mapper test");
         item.setText("mapper test");
         item.setEditer("mapper test");
         item.setDate(date);
         item.setPasswd("mapper test");
         
         mapper.dataInput(item);
     }
     
     @Test
     public void viewOneTest() {
    	 BoardItem item = mapper.viewOne(1L);
    	 System.out.println(item.toString());
     }
     
     @Test
     public void updateTest() {
    	 BoardItem item = new BoardItem();
    	 item.setText("update test");
    	 item.setTitle("update Test");
    	 item.setID(1L);
    	 int result = mapper.editOne(item);
    	 
    	 assertEquals(result, 1);
     }
}
