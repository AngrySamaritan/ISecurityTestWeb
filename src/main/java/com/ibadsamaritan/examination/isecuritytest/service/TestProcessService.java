package com.ibadsamaritan.examination.isecuritytest.service;

import com.ibadsamaritan.examination.isecuritytest.model.Answer;
import com.ibadsamaritan.examination.isecuritytest.model.Question;
import com.ibadsamaritan.examination.isecuritytest.repositories.AnswerRepo;
import com.ibadsamaritan.examination.isecuritytest.repositories.QuestionRepo;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TestProcessService {
    final QuestionRepo questionRepo;

    final AnswerRepo answerRepo;

    public TestProcessService(QuestionRepo questionRepo, AnswerRepo answerRepo) {
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    public String processAnswers(String answers) {
        JSONObject response = new JSONObject();
        JSONArray answersJson = new JSONArray(answers);
        int result = 0;
        for (int i = 0; i < answersJson.length(); i++) {
            JSONObject answer = answersJson.getJSONObject(i);
            JSONArray checkedAnswer = answer.getJSONArray("checked");
            for (int j = 0; j < checkedAnswer.length(); j++) {
                final Optional<Answer> answerOptional = answerRepo.findById(checkedAnswer.getLong(j));
                if (answerOptional.isPresent()) {
                    if (answerOptional.get().getRight()){
                        result++;
                    };
                }
            }
        }
        response.put("result", result);
        return response.toString();
    }
}
