package com.mcqcsvfileupload.fileuploadproject.question;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@jakarta.persistence.Entity
@Builder
@Table(name = "quiz_question_bank")
public class QuestionEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "sub_title", length = 255)
    private String subTitle;

    @Column(name = "topic", length = 255)
    private String topic;

    @Column(name = "sub_topic", length = 255)
    private String subTopic;

    @Column(name = "difficulty_level", length = 50)
    private String difficultyLevel;

    @Column(name = "code_snippet", columnDefinition = "TEXT")
    private String codeSnippet;

    @Column(name = "option1", length = 255)
    private String option1;

    @Column(name = "option2", length = 255)
    private String option2;

    @Column(name = "option3", length = 255)
    private String option3;

    @Column(name = "option4", length = 255)
    private String option4;

    @Column(name = "correct_answer", length = 255)
    private String correctAnswer;

    @Column(name = "correct_answer_description", columnDefinition = "TEXT")
    private String correctAnswerDescription;

    @Column(name = "question_image", length = 255)
    private String questionImage;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_by", columnDefinition = "uuid")
    private UUID createdBy;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}




