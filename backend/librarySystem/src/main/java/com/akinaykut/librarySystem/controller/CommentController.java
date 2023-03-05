package com.akinaykut.librarySystem.controller;

import com.akinaykut.librarySystem.dto.request.commentRequest.CreateCommentRequestDto;
import com.akinaykut.librarySystem.dto.response.CommentResponseDto;
import com.akinaykut.librarySystem.entities.Comment;
import com.akinaykut.librarySystem.repository.CommentRepository;
import com.akinaykut.librarySystem.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepository commentRepository;


    @GetMapping
    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    }

    @PostMapping(value = "/createComment")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CreateCommentRequestDto request){
        return new ResponseEntity<>(commentService.createComment(request), HttpStatus.CREATED);
    }


}
