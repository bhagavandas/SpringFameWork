package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.BookException;
import com.example.demo.model.BookModel;
import com.example.demo.repository.IBookRepository;

@Service
public class BookService implements IBookService {

	@Autowired
	IBookRepository repo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public BookDTO add(BookDTO bookDTO) {
		Optional<BookModel> bookModel = repo.findByBookName(bookDTO.getBookName());
		if (bookModel.isPresent()) {
			throw new BookException("Book already exists!!");
		}
		BookModel book = modelMapper.map(bookDTO, BookModel.class);

		repo.save(book);

		System.out.println("Successfully added");
		return bookDTO;
	}

	@Override
	public BookDTO findBook(String bookName) {
		Optional<BookModel> bookModel = repo.findByBookName(bookName);
		if (bookModel.isEmpty()) {
			throw new BookException("Book doesn't exist!!!");
		}
		BookDTO registerDTO = modelMapper.map(bookModel.get(), BookDTO.class);

		return registerDTO;
	}

	@Override
	public BookDTO findBookByAuthorName(String authorName) {
		Optional<BookModel> bookModel = repo.findByAuthorName(authorName);
		if (bookModel.isEmpty()) {
			throw new BookException("Book doesn't exist!!!");
		}
		BookDTO registerDTO = modelMapper.map(bookModel.get(), BookDTO.class);

		return registerDTO;
	}

	@Override
	public Optional<BookModel> deleteByBookName(String bookName) {
		Optional<BookModel> bookModel = repo.findByBookName(bookName);
		if (bookModel.isEmpty()) {
			throw new BookException("Book doesn't exist!!!");
		}
		repo.deleteByBookName(bookName);
		return bookModel;

	}

	@Override
	public BookDTO updateByBookName(BookDTO bookDTO, String bookName) {

		BookModel bookModel = modelMapper.map(bookDTO, BookModel.class);
		if (repo.findByBookName(bookDTO.getBookName()).isEmpty()){
				throw new BookException("Book Name doesn't exists");
		} else {
				bookModel.setBookName(bookName);
			repo.save(bookModel);
			return bookDTO;
	
		}
	}
	
	public List<BookDTO> getAllBooks(String role) {
		if (role.equals("Admin"))
			return repo.findAll().stream().map(user -> modelMapper.map(user, BookDTO.class))
					.collect(Collectors.toList());
		else {
			throw new BookException("You are not an Admin, Please check your Role");
		}
	}

	@Override
	public List<BookDTO> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
