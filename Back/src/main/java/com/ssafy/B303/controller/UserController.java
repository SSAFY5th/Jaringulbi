package com.ssafy.B303.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.B303.model.dto.UserDto;
import com.ssafy.B303.model.service.UserService;
import org.apache.ibatis.annotations.Delete;
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

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
@RequestMapping(path="/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<UserDto> signup(@RequestParam Map<String, String> map, Model model, HttpSession session) {
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

    @PostMapping("{login_id}")
    public ResponseEntity<String> login(@RequestBody UserDto userdto,@RequestParam Map<String, String> map, Model model, HttpSession session) {
        System.out.println("로그인");
        String login_id = userdto.getLogin_id();
        String password = userdto.getPassword();
        map.put("login_id", login_id);
        map.put("password", password);
       
    	try {
            UserDto result = userService.login(map);
            if(result != null) { // 성공
            	ObjectMapper objectMapper = new ObjectMapper();
				//System.out.println(objectMapper.writeValueAsString(result));
				String str =objectMapper.writeValueAsString(result);
				System.out.println(str);
				return new ResponseEntity<String>(str, HttpStatus.OK);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
        }
        System.out.println("로그인성공");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<UserDto> delete(Model model, HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("login_id");
        try {
            userService.deleteUser(userDto);
            session.invalidate();
        } catch (Exception e1) {
            e1.printStackTrace();
            model.addAttribute("msg", "회원 정보 삭제 중 문제가 발생했습니다.");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/logout")
    public ResponseEntity<UserDto> logout(HttpSession session) {
        session.invalidate(); // 세션 다 지움
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
