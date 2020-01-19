package com.ibadsamaritan.examination.isecuritytest.service;

import com.ibadsamaritan.examination.isecuritytest.model.Question;
import com.ibadsamaritan.examination.isecuritytest.repositories.QuestionRepo;
import org.springframework.stereotype.Service;

@Service
public class QuestionsService {
    final QuestionRepo questionRepo;

    public QuestionsService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public Iterable<Question> getAllQuestions(){
        return questionRepo.findAll();
    }
}
