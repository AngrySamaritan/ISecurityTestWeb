package com.ibadsamaritan.examination.isecuritytest.control;

import com.ibadsamaritan.examination.isecuritytest.service.QuestionsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    final QuestionsService questionsService;

    public MainController(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/test")
    public String test(@RequestParam Model model) {
        model.addAttribute("questions", questionsService.getAllQuestions());
        return "test";
    }
}
