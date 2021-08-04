package com.ssafy.B303.controller;


import com.ssafy.B303.model.dto.AccountBookDto;
import com.ssafy.B303.model.service.AccountBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/accountbook")
public class AccountBookController {

    private final AccountBookService accountBookService;

    @Autowired
    public AccountBookController(AccountBookService accountBookService) {
        this.accountBookService = accountBookService;
    }

    @PostMapping
    public ResponseEntity<AccountBookDto> addAccountBook(@RequestParam Map<String, String> map, Model model, HttpSession session) {
        AccountBookDto accountBookDto = new AccountBookDto(
                0,
                LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(map.get("date")+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul"))),
                //시분초는 일단 기본값
                Integer.parseInt(map.get("price").toString()),
                Integer.parseInt(map.get("category").toString()),
                map.get("used").toString(),
                map.get("contents").toString(),
                1 );    //일단은 id 1. 나중에 로그인 정보에서 id값 가져와야함
        try{
            accountBookService.insertAccountBook(accountBookDto);
        } catch(Exception e){
            e.printStackTrace();
            model.addAttribute("msg", "가계부 등록 중 문제가 발생했습니다.");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AccountBookDto>>  monthAccountBook(@RequestParam String date,Model model, HttpSession session){
        int month = LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(date+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul")))
                .getMonthValue(); //getMonth()는 AUGUST를 리턴함..
        List<AccountBookDto> result = new LinkedList<>();
        int monthIncomes = 0, monthOutgoings = 0, monthSum = 0;
        try {
            result = accountBookService.selectMonth(month, 1);  //user_id 받아와서 넣어야함
            monthIncomes = accountBookService.monthIncomes(month);
            monthOutgoings = accountBookService.monthOutgoings(month);
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(monthIncomes);
        System.out.println(monthOutgoings);
        model.addAttribute("monthIncomes", monthIncomes);
        model.addAttribute("monthOutgoings", monthOutgoings);
        model.addAttribute("monthSum", monthIncomes+monthOutgoings);
        return new ResponseEntity<List<AccountBookDto>>(result, HttpStatus.OK);
    }

    @GetMapping(value = "detail")
    public ResponseEntity<List<AccountBookDto>> dayAccountBook(@RequestParam String date, HttpSession session) {
        int month = LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(date+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul")))
                .getMonthValue();
        int day = LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(date+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul")))
                .getDayOfMonth();
        List<AccountBookDto> result = new LinkedList<>();
        try {
            result = accountBookService.selectDay(month,day, 1);  //user_id 받아와서 넣어야함
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<AccountBookDto>>(result, HttpStatus.OK);
    }

    @PutMapping(value = "detail")
    public ResponseEntity<AccountBookDto> modifyAccountBook(@RequestParam Map<String, String> map, HttpSession session){
        AccountBookDto accountBookDto = new AccountBookDto(
                Integer.parseInt(map.get("id").toString()),
                LocalDateTime.from(Instant.from(DateTimeFormatter.ISO_DATE_TIME.parse(map.get("date")+"T00:00:00+09:00")).atZone(ZoneId.of("Asia/Seoul"))),
                //시분초는 일단 기본값
                Integer.parseInt(map.get("price").toString()),
                Integer.parseInt(map.get("category").toString()),
                map.get("used").toString(),
                map.get("contents").toString(),
                1 );    //일단은 id 1. 나중에 로그인 정보에서 id값 가져와야함
        try {
            accountBookService.modifyAccountBook(accountBookDto);
        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping(value = "detail")
    public ResponseEntity modifyAccountBook(@RequestParam int id, HttpSession session) {
        try {
            accountBookService.deleteAccountBook(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
