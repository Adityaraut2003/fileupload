package com.mcqcsvfileupload.fileuploadproject.services;


import com.mcqcsvfileupload.fileuploadproject.dtos.UserRequest;
import com.mcqcsvfileupload.fileuploadproject.dtos.UserResponse;
import com.mcqcsvfileupload.fileuploadproject.entities.Users;
import com.mcqcsvfileupload.fileuploadproject.repositories.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class UserService {

    @Autowired
    private UsersRepository userRepository;

    public UserResponse createUser(@Valid UserRequest userRequest){
        Users user = new  Users();
        user.setUserName(userRequest.getUserName());
        user.setUserEmail(userRequest.getUserEmail());
        user.setPassword(userRequest.getPassword());

        Users savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

       public List<UserResponse> getAllUsers(){
            return userRepository.findAll().stream()
                    .map(this::mapToResponse)
                    .collect(Collectors.toList());
       }



    public UserResponse mapToResponse(Users user){
        return new UserResponse(
                user.getUserId(),
                user.getUserName(),
                user.getUserEmail()
        );
    }

}
