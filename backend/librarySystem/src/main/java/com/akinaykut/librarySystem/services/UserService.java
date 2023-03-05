package com.akinaykut.librarySystem.services;

import com.akinaykut.librarySystem.dto.request.userRequest.CreateUserRequestDto;
import com.akinaykut.librarySystem.dto.request.userRequest.UpdateUserRequestDto;
import com.akinaykut.librarySystem.dto.response.UserResponseDto;
import com.akinaykut.librarySystem.entities.User;
import com.akinaykut.librarySystem.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<UserResponseDto> getAllUsers(Optional<Long> userId) {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        if(userId.isPresent()){
            User user = userRepository.findById(userId.get()).orElse(null);
            if(user != null){
                userResponseDtos.add(modelMapper.map(user, UserResponseDto.class));
                return userResponseDtos;
            }
        }
        List<User> users = userRepository.findAll();
        userResponseDtos =  users.stream().map(user -> modelMapper.map(user, UserResponseDto.class)).collect(Collectors.toList());
        return userResponseDtos;
    }

    public UserResponseDto createUser(CreateUserRequestDto request) {
        User newUser = modelMapper.map(request, User.class);
        return modelMapper.map(userRepository.save(newUser), UserResponseDto.class);
    }


    public UserResponseDto updateUserById(Long userId, UpdateUserRequestDto request) {
        User foundUser = userRepository.findById(userId).orElse(null);

        if(foundUser == null){
           return null;
        }
        return modelMapper.map(userRepository.save(updateUser(foundUser, request)), UserResponseDto.class);
    }


    public String deleteUserById(Long userId){
        User foundUser = userRepository.findById(userId).orElse(null);

        if(foundUser != null){
            userRepository.deleteById(userId);
            return "User deleted successfully";
        }
        return "There is no such an user";
    }




    private User updateUser(User user, UpdateUserRequestDto request){
        if(request.getAddress() != null){
            user.setAddress(request.getAddress());
        }
        if (request.getName() != null) {
            user.setName(request.getName());
        }
        if (request.getSurname() != null) {
            user.setSurname(request.getSurname());
        }
        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }
        if (request.getPhoneNumber() != 0) {
            user.setPhoneNumber(request.getPhoneNumber());
        }
        return user;
    }

}
