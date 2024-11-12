package com.mcqcsvfileupload.fileuploadproject.controller;

import com.mcqcsvfileupload.fileuploadproject.services.QuizQuestionBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/quiz-question-bank")
@RequiredArgsConstructor
public class QuizQuestionBankController {
    public class QuizQuationBankController {

        @Autowired
        private QuizQuestionBankService quizQuestionBankService;

        @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
        public ResponseEntity<Integer> quizQuationBankService (
          @RequestPart("file")MultipartFile file
        )throws IOException{

            return ResponseEntity.ok(quizQuestionBankService.uploadCsv(file));


        }



    }
}