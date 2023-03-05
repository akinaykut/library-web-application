package com.akinaykut.librarySystem.dto.response;

import com.akinaykut.librarySystem.entities.Book;
import com.akinaykut.librarySystem.entities.Comment;
import com.akinaykut.librarySystem.entities.User;
import lombok.Data;

@Data
public class CommentResponseDto {

    public Long id;
    public String text;
    public User user;
    public Book book;

}
