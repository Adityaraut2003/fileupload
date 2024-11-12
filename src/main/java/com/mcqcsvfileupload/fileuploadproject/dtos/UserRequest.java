package com.mcqcsvfileupload.fileuploadproject.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "user name can not be  blank")
    @Size(min = 3,max = 50, message = "user name must be between 3 and 50 characters " )
    private String userName;


    @NotBlank(message = "email can not be blank")
    @Email(message = "email should be valid ")
    private String userEmail;


    @NotBlank(message = "password can not be blank")
    @Size(min = 8, message = "password must be at least 8 characters long")
    private String password;










}
