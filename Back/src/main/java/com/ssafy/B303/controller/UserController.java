package com.ssafy.B303.controller;

import com.ssafy.B303.domain.User;
import com.ssafy.B303.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping(value = "/user/signup")
    public String signUp(User user) {
        userService.join(user);
        return "signup";
    }

    @GetMapping(value = "/user/userlist")
    public String userList() {
        return "userlist";
    }

    @PostMapping(value = "/user/userlist")
    public String userList(Model model) {
        List<User> users = userService.findUsers();
        model.addAttribute("users", users);
        return "userlist";
    }

}
