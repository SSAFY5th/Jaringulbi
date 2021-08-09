package com.ssafy.B303.controller;

import com.google.gson.JsonObject;
import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.service.ChallengeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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


}
