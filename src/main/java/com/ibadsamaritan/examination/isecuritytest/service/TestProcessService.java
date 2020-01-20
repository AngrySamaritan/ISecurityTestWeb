package com.ibadsamaritan.examination.isecuritytest.service;

import com.ibadsamaritan.examination.isecuritytest.exceptions.NoSuchAnswerException;
import com.ibadsamaritan.examination.isecuritytest.model.Answer;
import com.ibadsamaritan.examination.isecuritytest.model.Question;
import com.ibadsamaritan.examination.isecuritytest.repositories.AnswerRepo;
import com.ibadsamaritan.examination.isecuritytest.repositories.QuestionRepo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;


import java.util.List;
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
        response.put("result", getResult(new JSONArray(answers)));
        List<Question> questionCount = (List<Question>) questionRepo.findAll();
        response.put("questions_count", questionCount.size());
        response.put("answers", getAllAnswers());
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

    private JSONObject getAllAnswers() {
        Iterable<Question> questions = questionRepo.findAll();
        JSONObject answers = new JSONObject();
        for (Question question: questions) {
            answers.put(String.valueOf(question.getId()), getAnswersForQuestion(question));
        }
        return answers;
    }

    private JSONArray getAnswersForQuestion(Question question){
        JSONArray answers = new JSONArray();
        for(Answer answer: question.getAnswers()){
            JSONObject answerJson = new JSONObject();
            answerJson.put("id", answer.getId());
            answerJson.put("is_right", answer.getRight());
            answers.put(answerJson);
        }
        return answers;
    }
}
