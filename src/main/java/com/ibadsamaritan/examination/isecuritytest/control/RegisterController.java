package com.ibadsamaritan.examination.isecuritytest.control;

import com.ibadsamaritan.examination.isecuritytest.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @GetMapping("/sign_up")
    public String signUpGet(Model model) {
        model.addAttribute("user", new UserDto());
        model.addAttribute("errors", null);
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUpPost(@ModelAttribute("user") @Valid UserDto userDto,
                             Errors errors, BindingResult result, WebRequest request,
                             Model model){
        if (result.hasErrors()){
            model.addAttribute("errors", errors);
            model.addAttribute("user", new UserDto());
            return "sign_up";
        } else
            return "index";
    }

}
