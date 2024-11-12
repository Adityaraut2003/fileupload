package com.mcqcsvfileupload.fileuploadproject.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users_table")


public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long userId;

    @Column(name = "userName", nullable = false, unique = true, length = 50)
            private String userName;

    @Column(name = "userEmail", nullable = false, unique = true, length = 50)
          private String userEmail;

    @Column(name = "password", nullable = false)
       private String password;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @PrePersist
    protected void createOn(){
        createdAt = LocalDateTime.now();
    }


}
