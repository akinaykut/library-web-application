package com.akinaykut.librarySystem.dto.request.bookRequest;


import lombok.Data;

@Data
public class CreateBookRequestDto {
    private String bookName;
    private int availableBookCount;
    private Long authorId;

}
