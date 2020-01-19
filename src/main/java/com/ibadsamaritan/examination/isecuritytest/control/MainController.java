package com.ibadsamaritan.examination.isecuritytest.control;

import com.ibadsamaritan.examination.isecuritytest.model.User;
import com.ibadsamaritan.examination.isecuritytest.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
