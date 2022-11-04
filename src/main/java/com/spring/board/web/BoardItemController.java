package com.spring.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.board.domain.BoardItem;
import com.spring.board.domain.Pagination;
import com.spring.board.service.BoardItemService;
import com.spring.board.service.PaginationService;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardItemController {
	
	@Autowired
	private BoardItemService service;
	@Autowired
	private PaginationService pService;
	
	@GetMapping("/page") // for pagination
	private ResponseEntity<Pagination> setPagination(@RequestParam(value = "page") int nowPage, @RequestParam(value = "size") int size) {
		Pagination page = pService.getPagination(nowPage, size);

        return new ResponseEntity<Pagination>(page, HttpStatus.OK);
    }
	
	@GetMapping("/list")
	private ResponseEntity<List<BoardItem>> showList(@RequestParam(value = "page") int nowPage, @RequestParam(value = "size") int size) {
        List<BoardItem> page = service.onePage(nowPage, size);
        return new ResponseEntity<List<BoardItem>>(page, HttpStatus.OK);
    }
	
	@GetMapping("/one/{id}")
	private ResponseEntity<BoardItem> showOne(@PathVariable(name = "id") Long id) {
        BoardItem item = service.oneView(id);

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

	@PostMapping("/add")
	private ResponseEntity<BoardItem> createOne(@RequestBody BoardItem item) {
        service.addItem(item);

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }
	
	@GetMapping("/edit/{id}")
	private ResponseEntity<BoardItem> editView(@PathVariable(name = "id") Long id) {
        BoardItem item = service.editView(id);

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }

	@PostMapping("/edit/{id}")
	private ResponseEntity<BoardItem> editOne(@PathVariable(name = "id") Long id, @RequestBody BoardItem item) {
		item.setID(id);
        service.editItem(item);

        return new ResponseEntity<BoardItem>(item, HttpStatus.OK);
    }
	
	@DeleteMapping("/del/{id}")
	private ResponseEntity<Boolean> deleteOne(@PathVariable(name = "id") Long id) {
		// delete clear = 1 / no delete = 0
		boolean result = service.deleteItem(id) == 0 ? false : true;
		
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}
}
