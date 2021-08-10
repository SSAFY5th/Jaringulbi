package com.ssafy.B303.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins= {"*"}, maxAge =6000)
@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<ChallengeDto>> getChallengeList(){
        List<ChallengeDto> challengeList = null;
        try {
            challengeList = challengeService.getChallengeList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<List<ChallengeDto>>(challengeList, HttpStatus.OK);
    }

    @GetMapping(value = "/detail/{id}")
    public ResponseEntity<JsonObject> getDetailChallengeList(@PathVariable int id){
        ChallengeDto challengeDto = null;
        int challengeUserNum = 0;
        try{
            challengeDto = challengeService.getChallenge(id);
            challengeUserNum = challengeService.getChallengeUserNum(id);
        } catch(Exception e){
            e.printStackTrace();
        }

        String challengeDtoToJson = new Gson().toJson(challengeDto);
        JsonObject obj = new JsonObject();

        int day = challengeDto.getEnd_date().getDayOfYear()
                -challengeDto.getStart_date().getDayOfYear();
        if(day / 7 >= 1)
            obj.addProperty("period", day/7 + "주");
        else
            obj.addProperty("period", day + "일");
        int start =  challengeDto.getStart_date().getDayOfYear() - LocalDateTime.now().getDayOfYear();
        if(start < 0) obj.addProperty("start", "");
        else obj.addProperty("start", start + "일 뒤 시작");

        obj.addProperty("title", challengeDto.getTitle());
        obj.addProperty("entry_fee", challengeDto.getEntry_fee());
        obj.addProperty("reward", challengeDto.getReward());
        obj.addProperty("description", challengeDto.getDescription());
        obj.addProperty("ChallengeUserNum", challengeUserNum);
        return new ResponseEntity<JsonObject>(obj, HttpStatus.OK);
    }

}
