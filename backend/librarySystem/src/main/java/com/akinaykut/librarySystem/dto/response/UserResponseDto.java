package com.akinaykut.librarySystem.dto.response;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String address;
    private int phoneNumber;

}
