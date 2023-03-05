package com.akinaykut.librarySystem.dto.response;

import com.akinaykut.librarySystem.entities.Author;
import lombok.Data;

@Data
public class BookResponseDto {

    private Long id;
    private String bookName;
    private int availableBookCount;
    private Author author;


}
