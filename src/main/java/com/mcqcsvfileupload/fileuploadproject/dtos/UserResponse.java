package com.mcqcsvfileupload.fileuploadproject.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponse {

      private Long userId;
      private String userName;
      private String userEmail;


}
