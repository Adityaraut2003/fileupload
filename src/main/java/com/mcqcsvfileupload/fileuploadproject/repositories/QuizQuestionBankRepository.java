package com.mcqcsvfileupload.fileuploadproject.repositories;

import com.mcqcsvfileupload.fileuploadproject.entities.QuizQuestionBank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuizQuestionBankRepository extends JpaRepository<QuizQuestionBank, UUID> {
}
