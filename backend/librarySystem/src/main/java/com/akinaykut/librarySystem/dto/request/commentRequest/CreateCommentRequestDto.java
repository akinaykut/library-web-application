package com.akinaykut.librarySystem.dto.request.commentRequest;

import lombok.Data;

@Data
public class CreateCommentRequestDto {

    private String text;
    private Long userId;
    private Long bookId;

}
