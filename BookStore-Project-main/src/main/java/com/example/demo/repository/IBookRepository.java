package com.example.demo.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.DTO.BookDTO;
import com.example.demo.model.BookModel;

@Repository
public interface IBookRepository extends JpaRepository<BookModel, Long> {

	Optional<BookModel> findByBookName(String bookName);

	BookDTO findByBookName(BookDTO bookDTO);

	Optional<BookModel> findByAuthorName(String authorName);

	void deleteByBookName(String bookName);

	boolean findByBookName(boolean empty);

	
}
