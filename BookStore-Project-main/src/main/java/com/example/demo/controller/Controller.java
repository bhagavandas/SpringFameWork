package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ResponseEntity;
import com.example.demo.DTO.BookDTO;
import com.example.demo.model.BookModel;
import com.example.demo.service.IBookService;


@RestController
public class Controller {

	@Autowired
	IBookService bookService;
	

	@PostMapping("/addBook")
	public ResponseEntity registerUser(@RequestBody BookDTO bookDTO) {
		BookDTO book = bookService.add(bookDTO);
		return new ResponseEntity(book, "Added successfully");
	}
	
	@GetMapping("/getBookByBookName")
	public ResponseEntity getBook(@RequestParam String bookName) {
		BookDTO book = bookService.findBook(bookName);
		return new ResponseEntity(book, "Fetched successfully");
	}

	@GetMapping("/getBookByAuthorName")
	public ResponseEntity getBookByAuthor(@RequestParam String authorName) {
		BookDTO book = bookService.findBookByAuthorName(authorName);
		return new ResponseEntity(book, "Fetched successfully");
	}
	
	@DeleteMapping("/deleteBook")
	public ResponseEntity deleteBookByBookName(@RequestParam String bookName) {
		Optional<BookModel> book = bookService.deleteByBookName(bookName);
		return new ResponseEntity(book, "Deleted successfully");
	}
	
	@PutMapping("/updateBook")
	public ResponseEntity updateEmployee(@RequestBody BookDTO bookDTO, @RequestParam String bookName) {
		BookDTO update = bookService.updateByBookName(bookDTO, bookName);
		return new ResponseEntity(update, "Successfully updated by BookName");
	}
	
	@GetMapping("/getAllBooks")
	public ResponseEntity getAllBooks(@RequestParam String role) {
		List<BookDTO> bookModel = bookService.getAllBooks(role);
		return new ResponseEntity(bookModel, "Fetched Books successfully");
	}
}
