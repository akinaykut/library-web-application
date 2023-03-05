package com.akinaykut.librarySystem.controller;

import com.akinaykut.librarySystem.dto.request.userRequest.CreateUserRequestDto;
import com.akinaykut.librarySystem.dto.request.userRequest.UpdateUserRequestDto;
import com.akinaykut.librarySystem.dto.response.UserResponseDto;
import com.akinaykut.librarySystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(@RequestParam("userId") Optional<Long> userId){
        return new ResponseEntity<>(userService.getAllUsers(userId), HttpStatus.OK);
    }

    @PostMapping(value = "/createUser")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto request){
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateUser/{userId}")
    public ResponseEntity<UserResponseDto> updateUserById(@PathVariable Long userId, @RequestBody UpdateUserRequestDto request){
        return new ResponseEntity<>(userService.updateUserById(userId, request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteUser/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
        return new ResponseEntity<>(userService.deleteUserById(userId), HttpStatus.OK);
    }

}
