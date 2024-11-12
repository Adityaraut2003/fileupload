package com.mcqcsvfileupload.fileuploadproject.services;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CsvRepresentation {

    @CsvBindByName(column = "id")
    private UUID id;

    @CsvBindByName(column = "title")
    private String title;

    @CsvBindByName(column = "sub_title")
    private String subTitle;

    @CsvBindByName(column = "topic")
    private String topic;

    @CsvBindByName(column = "sub_topic")
    private String subTopic;

    @CsvBindByName(column = "difficulty_level")
    private String difficultyLevel;

    @CsvBindByName(column = "code_snippet")
    private String codeSnippet;

    @CsvBindByName(column = "option1")
    private String option1;

    @CsvBindByName(column = "option2")
    private String option2;

    @CsvBindByName(column = "option3")
    private String option3;

    @CsvBindByName(column = "option4")
    private String option4;

    @CsvBindByName(column = "correct_answer")
    private String correctAnswer;

    @CsvBindByName(column = "correct_answer_desription")
    private String correctAnswerDescription;

    @CsvBindByName(column = "quation_image")
    private String questionImage;

    @CsvBindByName(column = "is_active")
    private boolean isActive;

    @CsvBindByName(column = "created_at")
    private LocalDateTime createdAt;

    @CsvBindByName(column = "updated_at")
    private LocalDateTime updatedAt;

    @CsvBindByName(column = "created_by")
    private UUID createdBy;

}




