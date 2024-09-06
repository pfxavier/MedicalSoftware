package com.example.personalFinanceTracker.controller;

import com.example.personalFinanceTracker.entity.User;
import com.example.personalFinanceTracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService= userService;
    }



    @RequestMapping("/register")
    public String showRegisterPg(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "register";
        }else {

            System.out.println("User created : ID:" + userService.addUser(user));

            return "redirect:/user/register";
        }
    }

    @RequestMapping("/login")
    public String showLoginPg(Model model) {
        model.addAttribute("user", new User());

        return "login";
    }

}
