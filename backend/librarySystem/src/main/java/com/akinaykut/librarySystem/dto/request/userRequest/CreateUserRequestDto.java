package com.akinaykut.librarySystem.dto.request.userRequest;

import lombok.Data;

@Data
public class CreateUserRequestDto {

    private String name;
    private String surname;
    private String address;
    private int phoneNumber;
    private String password;

}
