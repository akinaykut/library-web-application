package com.akinaykut.librarySystem.services;

import com.akinaykut.librarySystem.dto.request.bookRequest.CreateBookRequestDto;
import com.akinaykut.librarySystem.dto.request.bookRequest.UpdateBookRequestDto;
import com.akinaykut.librarySystem.dto.response.BookResponseDto;
import com.akinaykut.librarySystem.entities.Author;
import com.akinaykut.librarySystem.entities.Book;
import com.akinaykut.librarySystem.repository.AuthorRepository;
import com.akinaykut.librarySystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    ModelMapper modelMapper;

    public List<BookResponseDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookResponseDto> bookResponseDtos = books.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).collect(Collectors.toList());
        return bookResponseDtos;
    }

    public BookResponseDto createBook(CreateBookRequestDto request) {
        Book newBook = new Book();
        newBook.setBookName(request.getBookName());
        newBook.setAvailableBookCount(request.getAvailableBookCount());
        Author author = authorRepository.findById(request.getAuthorId()).orElse(null);
        if(author != null){
            newBook.setAuthor(author);
            author.addBook(newBook);
        }
        bookRepository.save(newBook);

        return modelMapper.map(newBook, BookResponseDto.class);
    }

    public BookResponseDto updateBookById(Long bookId, UpdateBookRequestDto request) {
        Book foundBook = bookRepository.findById(bookId).orElse(null);

        if(foundBook != null){
            Optional<Author> foundAuthor = authorRepository.findById(request.getAuthorId());
            if(foundAuthor.isPresent()){
                foundBook.setBookName(request.getBookName());
                foundBook.setAvailableBookCount(request.getAvailableBookCount());
                foundBook.setAuthor(foundAuthor.get());
                return modelMapper.map(bookRepository.save(foundBook), BookResponseDto.class);
            }
        }
        return null;



    }

    public String deleteBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        if(book.isPresent()){
            bookRepository.deleteById(bookId);
            return "The book has deleted successfully";
        }
        return "There is no such a book";


    }
}
