package com.akinaykut.librarySystem.controller;

import com.akinaykut.librarySystem.dto.request.bookRequest.CreateBookRequestDto;
import com.akinaykut.librarySystem.dto.request.bookRequest.UpdateBookRequestDto;
import com.akinaykut.librarySystem.dto.response.BookResponseDto;
import com.akinaykut.librarySystem.repository.BookRepository;
import com.akinaykut.librarySystem.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping(value = "/createBook")
    public ResponseEntity<BookResponseDto> createBook(@RequestBody CreateBookRequestDto request){
        return new ResponseEntity<>(bookService.createBook(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateBook/{bookId}")
    public ResponseEntity<BookResponseDto> updateBookById(@PathVariable Long bookId, @RequestBody UpdateBookRequestDto request){
        return new ResponseEntity<>(bookService.updateBookById(bookId, request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteBook/{bookId}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long bookId){
        return new ResponseEntity<>(bookService.deleteBookById(bookId), HttpStatus.OK);
    }



}
