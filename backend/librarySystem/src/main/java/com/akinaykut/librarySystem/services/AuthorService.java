package com.akinaykut.librarySystem.services;

import com.akinaykut.librarySystem.dto.response.AuthorResponseDto;
import com.akinaykut.librarySystem.entities.Author;
import com.akinaykut.librarySystem.entities.Book;
import com.akinaykut.librarySystem.repository.AuthorRepository;
import com.akinaykut.librarySystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<AuthorResponseDto> getAllAuthors(Optional<Long> authorId) {
        List<Author> authors = authorRepository.findAll();
        List<AuthorResponseDto> responseDto = authors.stream().map(author -> modelMapper.map(author, AuthorResponseDto.class)).collect(Collectors.toList());
        return responseDto;
    }
}
