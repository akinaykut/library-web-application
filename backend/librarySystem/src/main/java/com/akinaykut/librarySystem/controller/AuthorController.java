package com.akinaykut.librarySystem.controller;

import com.akinaykut.librarySystem.dto.response.AuthorResponseDto;
import com.akinaykut.librarySystem.entities.Author;
import com.akinaykut.librarySystem.repository.AuthorRepository;
import com.akinaykut.librarySystem.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;


    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> getAllAuthors(@RequestParam("authorId") Optional<Long> authorId ){
        return new ResponseEntity<>(authorService.getAllAuthors(authorId), HttpStatus.OK);
    }


}
