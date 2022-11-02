package com.spring.board.mapper;

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
         
         mapper.dataInput(item);;
         
     }
     
 
}
