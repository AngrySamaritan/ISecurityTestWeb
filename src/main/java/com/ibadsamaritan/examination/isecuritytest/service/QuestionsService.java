package com.ibadsamaritan.examination.isecuritytest.service;

import com.ibadsamaritan.examination.isecuritytest.model.Question;
import com.ibadsamaritan.examination.isecuritytest.repositories.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
    final QuestionRepo questionRepo;

    public QuestionsService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Iterable<Question> getAllQuestions(){
        return questionRepo.findAll();
    }

    public int getQuestionAmount(){
        List<Question> allQuestions = (List<Question>)getAllQuestions();
        return allQuestions.size();
    }
}
