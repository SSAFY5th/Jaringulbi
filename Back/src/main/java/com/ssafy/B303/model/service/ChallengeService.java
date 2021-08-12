package com.ssafy.B303.model.service;

import com.ssafy.B303.model.dto.ChallengeDto;
import com.ssafy.B303.model.dto.ChallengeReviewDto;
import com.ssafy.B303.model.dto.EnterChallengeVo;
import com.ssafy.B303.model.dto.UserChallengeDto;

import java.util.List;

public interface ChallengeService {
    List<ChallengeDto> getChallengeList();
    ChallengeDto getChallenge(int id);
    int getChallengeUserNum(int id);
    void enterChallenge(EnterChallengeVo enterChallengeVo);
    List<UserChallengeDto> getUserChallengeList(int user_id);
    List<ChallengeReviewDto> getChallengeReviewList(int challenge_id);
    void addChallengeReview(ChallengeReviewDto challengeReviewDto);

    void updateChallengeReview(ChallengeReviewDto challengeReviewDto);

    void deleteChallengeReview(ChallengeReviewDto challengeReviewDto);
}
