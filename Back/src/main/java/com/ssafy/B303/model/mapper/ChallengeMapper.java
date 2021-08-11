package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.dto.EnterChallengeVo;

import java.util.List;

public interface ChallengeMapper {
    List<ChallengeDto> getChallengeList();
    ChallengeDto getChallenge(int id);
    Integer getChallengeUserNum(int id);
    void enterChallenge(EnterChallengeVo enterChallengeVo);
}
