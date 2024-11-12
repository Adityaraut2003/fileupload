package com.mcqcsvfileupload.fileuploadproject.question;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/question")
@RequiredArgsConstructor  // Ensures constructor-based injection
public class QuestionController {

    private final QuestionService service; // Spring will inject the service

    @PostMapping(value = "/upload", consumes = {"multipart/form-data"})
    public ResponseEntity<Integer> uploadQuestions(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok(service.uploadQuestion(file));
    }
}
