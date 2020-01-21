package com.ibadsamaritan.examination.isecuritytest.control;

import com.ibadsamaritan.examination.isecuritytest.exceptions.NoSuchAnswerException;
import com.ibadsamaritan.examination.isecuritytest.service.QuestionsService;
import com.ibadsamaritan.examination.isecuritytest.service.TestProcessService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    final QuestionsService questionsService;
    final TestProcessService processingTestService;

    public MainController(QuestionsService questionsService, TestProcessService processingTestService) {
        this.questionsService = questionsService;
        this.processingTestService = processingTestService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("count", questionsService.getQuestionAmount());
        model.addAttribute("nl", '\n');
        return "index";
    }


    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("questions", questionsService.getAllQuestions());
        return "test";
    }

    @ResponseBody
    @PostMapping("/test")
    public String processTest(@RequestParam(name = "data") String answers, Model model) throws NoSuchAnswerException {
        return processingTestService.processAnswers(answers);
    }
}
