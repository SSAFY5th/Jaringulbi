package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.dto.EnterChallengeVo;

import java.util.List;

public interface ChallengeService {
    List<ChallengeDto> getChallengeList();
    ChallengeDto getChallenge(int id);
    int getChallengeUserNum(int id);
    void enterChallenge(EnterChallengeVo enterChallengeVo);
}
