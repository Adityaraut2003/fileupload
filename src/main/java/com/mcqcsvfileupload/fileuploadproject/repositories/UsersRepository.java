package com.mcqcsvfileupload.fileuploadproject.repositories;

import com.mcqcsvfileupload.fileuploadproject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {

}
