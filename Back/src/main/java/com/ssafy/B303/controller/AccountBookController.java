package com.ssafy.B303.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.dto.UserDto;
import com.ssafy.B303.model.service.AccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
@RequestMapping("/accountbook")
public class AccountBookController {

    private final AccountBookService accountBookService;

    @Autowired
    public AccountBookController(AccountBookService accountBookService) {
        this.accountBookService = accountBookService;
    }

    @PostMapping
    public ResponseEntity<AccountBookDto> addAccountBook(@RequestBody AccountBookDto tempAccountBookDto, HttpSession session) {
        //UserDto userDto = (UserDto) session.getAttribute("userinfo");
        //int user_id = userDto.getId();
        AccountBookDto accountBookDto = new AccountBookDto(
                0,
                //LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(tempAccountBookDto.getDate()+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul"))),
                //시분초는 일단 기본값
                tempAccountBookDto.getDate(),
                tempAccountBookDto.getPrice(),
                tempAccountBookDto.getCategory(),
                tempAccountBookDto.getUsed(),
                tempAccountBookDto.getContents(),
                tempAccountBookDto.getUser_id() );    //일단은 id 1. 나중에 로그인 정보에서 id값 가져와야함
        try{
            accountBookService.insertAccountBook(accountBookDto);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<JsonObject>  monthAccountBook(@RequestParam String date, Model model, HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("userinfo");
        int user_id = userDto.getId();
        int month = Integer.parseInt(date.substring(5, 7)); //월만 빼오기
        Map<String, Object> result = new HashMap<String, Object>();
        List<Number> incomes = new LinkedList<>();
        List<Number> outgoings = new LinkedList<>();
        int monthIncomes = 0, monthOutgoings = 0, monthSum = 0;
        try {
            monthIncomes = accountBookService.monthIncomes(month, user_id);
            monthOutgoings = accountBookService.monthOutgoings(month, user_id);
            incomes = accountBookService.dayIncomes(month, user_id);
            outgoings = accountBookService.dayOutgoings(month, user_id);
        } catch (Exception e){
            e.printStackTrace();
        }

        List<Number> daySum = new LinkedList<>();
        for(int i = 0; i < incomes.size(); i++){
            int a = 0, b = 0;
            if(incomes.get(i) != null) a = incomes.get(i).intValue();
            if(outgoings.get(i) != null) b = outgoings.get(i).intValue();
            daySum.add(a + b);
        }

        System.out.println(incomes);


        String incomesToJson = new Gson().toJson(incomes);
        String outgoingsToJson = new Gson().toJson(outgoings);
        String daySumToJson = new Gson().toJson(daySum);

        JsonObject obj = new JsonObject();
        obj.addProperty("monthIncomes", monthIncomes);
        obj.addProperty("monthOutgoings", monthOutgoings);
        obj.addProperty("monthSum", monthIncomes+monthOutgoings);
        obj.addProperty("incomes", incomesToJson);
        obj.addProperty("outgoings", outgoingsToJson);
        obj.addProperty("daySum", daySumToJson);



        return new ResponseEntity<JsonObject>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "detail")
    public ResponseEntity<List<AccountBookDto>> dayAccountBook(@RequestParam String date, HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute("userinfo");
        int user_id = userDto.getId();
        int month = LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(date+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul")))
                .getMonthValue();
        int day = LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(date+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul")))
                .getDayOfMonth();
        List<AccountBookDto> result = new LinkedList<>();
        try {
            result = accountBookService.selectDay(month,day, user_id);  //user_id 받아와서 넣어야함
        } catch (Exception e){
            e.printStackTrace();
        }

        JsonObject obj = new JsonObject();
        String listToJson = new Gson().toJson(result);
        obj.addProperty("accountBookList", listToJson);

        System.out.println(result);
        return new ResponseEntity<List<AccountBookDto>>(result, HttpStatus.OK);
    }

    @PutMapping(value = "detail")
    public ResponseEntity<AccountBookDto> modifyAccountBook(@RequestBody AccountBookDto tempAccountBookDto, HttpSession session){
        UserDto userDto = (UserDto) session.getAttribute("userinfo");
        int user_id = userDto.getId();
        String login_id = userDto.getLogin_id();
        AccountBookDto accountBookDto = new AccountBookDto(
                tempAccountBookDto.getId(),
                //LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(tempAccountBookDto.getDate()+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul"))),
                //시분초는 일단 기본값
                tempAccountBookDto.getDate(),
                tempAccountBookDto.getPrice(),
                tempAccountBookDto.getCategory(),
                tempAccountBookDto.getUsed(),
                tempAccountBookDto.getContents(),
                tempAccountBookDto.getUser_id());    //일단은 id 1. 나중에 로그인 정보에서 id값 가져와야함
        try {
            accountBookService.modifyAccountBook(accountBookDto);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping(value = "detail")
    public ResponseEntity deleteAccountBook(@RequestParam int id, HttpSession session) {
        try {
            accountBookService.deleteAccountBook(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
