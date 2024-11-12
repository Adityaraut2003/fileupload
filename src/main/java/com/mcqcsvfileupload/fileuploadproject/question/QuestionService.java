package com.mcqcsvfileupload.fileuploadproject.question;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository repository; // access repository

    public Integer uploadQuestion(MultipartFile file) throws IOException { // make a function upload student
        Set<QuestionEntity> question = parseCsv(file);
        repository.saveAll(question);
        return question.size();
    }

    private Set<QuestionEntity> parseCsv(MultipartFile file) throws IOException {
        try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<Csv> strategy =
                    new HeaderColumnNameMappingStrategy<>();
            strategy.setType(Csv.class);
            CsvToBean<Csv> csvToBean =
                    new CsvToBeanBuilder<Csv>(reader)
                            .withMappingStrategy(strategy)
                            .withIgnoreEmptyLine(true)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build();
            return csvToBean.parse()
                    .stream()
                    .map(csvLine -> QuestionEntity.builder()
                            .title(csvLine.getTitle())
                            .subTitle(csvLine.getSubTitle())
                            .topic(csvLine.getTopic())
                            .subTopic(csvLine.getSubTopic())
                            .difficultyLevel(csvLine.getDifficultyLevel())
                            .codeSnippet(csvLine.getCodeSnippet())
                            .option1(csvLine.getOption1())
                            .option2(csvLine.getOption2())
                            .option3(csvLine.getOption3())
                            .option4(csvLine.getOption4())
                            .correctAnswer(csvLine.getCorrectAnswer())
                            .correctAnswerDescription(csvLine.getCorrectAnswerDescription())
                            .questionImage(csvLine.getQuestionImage())
                            .isActive(csvLine.isActive())
                            .createdAt(null)  // Set to null as it will be handled in the entity
                            .updatedAt(null)  // Set to null as it will be handled in the entity
                            .createdBy(null)  // Set to null, assuming it is generated dynamically
                            .build()
                    )
                    .collect(Collectors.toSet());
        }
    }
}
