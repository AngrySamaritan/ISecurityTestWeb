package com.ibadsamaritan.examination.isecuritytest.service;

import com.ibadsamaritan.examination.isecuritytest.exceptions.NoSuchAnswerException;
import com.ibadsamaritan.examination.isecuritytest.model.Answer;
import com.ibadsamaritan.examination.isecuritytest.repositories.AnswerRepo;
import com.ibadsamaritan.examination.isecuritytest.repositories.QuestionRepo;
import org.json.JSONArray;
import org.json.JSONObject;
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

    public String processAnswers(String answers) throws NoSuchAnswerException {
        JSONObject response = new JSONObject();
        response.put("status", "ok");
        response.put("result", getResult(new JSONArray(answers)));
        return response.toString();
    }

    private int getResult(JSONArray answersJson) throws NoSuchAnswerException {
        int result = 0;
        for (int i = 0; i < answersJson.length(); i++) {
            JSONObject answer = answersJson.getJSONObject(i);
            JSONArray checkedAnswer = answer.getJSONArray("checked");
            for (int j = 0; j < checkedAnswer.length(); j++) {
                if (checkAnswer(checkedAnswer.getLong(j))) {
                    result++;
                }
            }
        }
        return result;
    }

    private boolean checkAnswer(Long answerId) throws NoSuchAnswerException {
        final Optional<Answer> answerOptional = answerRepo.findById(answerId);
        if (answerOptional.isPresent()) {
            return (answerOptional.get().getRight());
        } else throw new NoSuchAnswerException("No answer with id " + answerId + " in the database");
    }

    public String noSuchAnswer(Throwable e){
        JSONObject response = new JSONObject();
        response.put("status", "error");
        response.put("error_code", "1000");
        response.put("error_text", e.getMessage());
        return response.toString();
    }
}
