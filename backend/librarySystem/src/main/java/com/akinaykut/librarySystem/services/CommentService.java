package com.akinaykut.librarySystem.services;

import com.akinaykut.librarySystem.dto.request.commentRequest.CreateCommentRequestDto;
import com.akinaykut.librarySystem.dto.response.CommentResponseDto;
import com.akinaykut.librarySystem.entities.Book;
import com.akinaykut.librarySystem.entities.Comment;
import com.akinaykut.librarySystem.entities.User;
import com.akinaykut.librarySystem.repository.BookRepository;
import com.akinaykut.librarySystem.repository.CommentRepository;
import com.akinaykut.librarySystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<CommentResponseDto> getAllComments(){
        List<Comment> comments = commentRepository.findAll();
        List<CommentResponseDto> responseDto = comments.stream().map(comment -> modelMapper.map(comment, CommentResponseDto.class)).collect(Collectors.toList());
        return responseDto;
    };

    public CommentResponseDto createComment(CreateCommentRequestDto request) {
        User foundUser = userRepository.findById(request.getUserId()).orElse(null);
        Book foundBook = bookRepository.findById(request.getBookId()).orElse(null);

        if(foundUser != null && foundBook != null && request.getText() != null){
            Comment newComment = new Comment(foundBook, foundUser, request.getText());
            return modelMapper.map(commentRepository.save(newComment), CommentResponseDto.class);
        }
        return null;
    }
}
