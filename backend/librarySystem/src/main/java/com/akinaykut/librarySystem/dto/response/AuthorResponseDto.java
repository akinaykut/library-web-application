package com.akinaykut.librarySystem.dto.response;

import com.akinaykut.librarySystem.entities.Book;
import lombok.Data;

import java.util.List;

@Data
public class AuthorResponseDto {

    private Long id;
    private String name;
    private String surname;
    private List<Book> books;


}
