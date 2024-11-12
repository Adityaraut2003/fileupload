package com.mcqcsvfileupload.fileuploadproject.services;

import com.mcqcsvfileupload.fileuploadproject.entities.QuizQuestionBank;
import com.mcqcsvfileupload.fileuploadproject.repositories.QuizQuestionBankRepository;
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

public class QuizQuestionBankService {

    private  final QuizQuestionBankRepository quizQuestionBankRepository;

    public Integer uploadCsv(MultipartFile file) throws IOException{
        Set<QuizQuestionBank> quizQuestionBank = parseCsv(file);
      quizQuestionBankRepository.saveAll(quizQuestionBank);
       return null;

    }


    private Set<QuizQuestionBank> parseCsv(MultipartFile file ) throws IOException{
      try(Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))){
          HeaderColumnNameMappingStrategy<CsvRepresentation> strategy =
             new HeaderColumnNameMappingStrategy<>();

          strategy.setType(CsvRepresentation.class);
          CsvToBean<CsvRepresentation> csvToBean = new CsvToBeanBuilder<CsvRepresentation>(reader)
                  .withMappingStrategy(strategy)
                  .withIgnoreEmptyLine(true)
                  .withIgnoreLeadingWhiteSpace(true)
                  .build();

                return csvToBean.parse()
                  .stream()
                  .map(csvLine  -> QuizQuestionBank.builder()
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
                          .createdAt(csvLine.getCreatedAt())
                          .updatedAt(csvLine.getUpdatedAt())
                          .createdBy(csvLine.getCreatedBy())
                          .build()
                       )
                  .collect(Collectors.toSet());










      }




    }

}