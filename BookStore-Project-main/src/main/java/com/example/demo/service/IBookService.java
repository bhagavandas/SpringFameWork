package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.BookModel;

public interface IBookService {

	BookDTO add(BookDTO bookDTO);

	BookDTO findBook(String bookName);
	BookDTO findBookByAuthorName(String authorName);

	Optional<BookModel> deleteByBookName(String bookName);

	BookDTO updateByBookName(BookDTO bookDTO, String bookName);

	List<BookDTO> getAllBooks();

	List<BookDTO> getAllBooks(String role);

	

}
