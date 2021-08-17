package com.ssafy.B303.model.mapper;

import com.ssafy.B303.model.dto.*;

import java.util.List;

public interface ChallengeMapper {
    List<ChallengeDto> getChallengeList();
    ChallengeDto getChallenge(int id);
    Integer getChallengeUserNum(int id);
    void enterChallenge(EnterChallengeVo enterChallengeVo);
    List<UserChallengeDto> getUserChallengeList(int user_id);
    List<ChallengeReviewDto> getChallengeReviewList(int challenge_id);
    void addChallengeReview(ChallengeReviewDto challengeReviewDto);

    void updateChallengeReview(ChallengeReviewDto challengeReviewDto);

    void deleteChallengeReview(ChallengeReviewDto challengeReviewDto);
    List<PostDto> relatedPost(int id) throws Exception;
}
