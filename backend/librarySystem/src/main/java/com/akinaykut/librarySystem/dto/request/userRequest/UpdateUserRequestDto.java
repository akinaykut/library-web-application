package com.akinaykut.librarySystem.dto.request.userRequest;

import lombok.Data;

@Data
public class UpdateUserRequestDto {

    private String name;
    private String surname;
    private String address;
    private int phoneNumber;
    private String password;

}
