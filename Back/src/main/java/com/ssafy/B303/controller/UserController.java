package com.ssafy.B303.controller;

import com.ssafy.B303.model.dto.UserDto;
import com.ssafy.B303.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/signup")
    public ResponseEntity<UserDto> regist(@RequestParam Map<String, String> map, Model model, HttpSession session) {
        UserDto userDto = new UserDto(
                map.get("login_id"),
                map.get("password"),
                map.get("nickname"),
                map.get("phone"));
        try{
            userService.insertUser(userDto);
            session.setAttribute("userinfo", userDto);
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg", "회원 가입 중 문제가 발생했습니다.");
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/userlist")
    public String userList() {
        return "userlist";
    }

    @PostMapping(value = "/user/userlist")
    public String userList(Model model) {
        return "";
    }

}
