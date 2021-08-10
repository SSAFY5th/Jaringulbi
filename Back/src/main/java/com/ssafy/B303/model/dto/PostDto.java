package com.ssafy.B303.model.dto;

import java.time.LocalDateTime;
import java.util.List;

//@Data // getter, setter 자동으로 만들어줌
//@NoArgsConstructor // 디폴트 생성자 만들어줌
//@AllArgsConstructor // 모든 파라미터를 가진 생성자 만들어줌
//@JsonInclude(JsonInclude.Include.NON_NULL) // not_null인 경우만 포함한다. json을 만들 때 property가 null이면 만들지 말라
public class PostDto {
    private int id;
    private int user_id;
    private String nickname;
    private LocalDateTime created_time;
    private String title;
    private String contents;
    private Integer price;
    private String image;
    private int board_category;
    private Integer challenge_id;
    private Integer upCount;
    private List<UpDownDto> up;
    private Integer downCount;
    private List<UpDownDto> down;
    private Integer commentCount;
    private List<CommentDto> comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDateTime getCreated_time() {
        return created_time;
    }

    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getBoard_category() {
        return board_category;
    }

    public void setBoard_category(int board_category) {
        this.board_category = board_category;
    }

    public Integer getChallenge_id() {
        return challenge_id;
    }

    public void setChallenge_id(Integer challenge_id) {
        this.challenge_id = challenge_id;
    }

    public Integer getUpCount() {
        return upCount;
    }

    public void setUpCount(Integer upCount) {
        this.upCount = upCount;
    }

    public List<UpDownDto> getUp() {
        return up;
    }

    public void setUp(List<UpDownDto> up) {
        this.up = up;
    }

    public Integer getDownCount() {
        return downCount;
    }

    public void setDownCount(Integer downCount) {
        this.downCount = downCount;
    }

    public List<UpDownDto> getDown() {
        return down;
    }

    public void setDown(List<UpDownDto> down) {
        this.down = down;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<CommentDto> getComment() {
        return comment;
    }

    public void setComment(List<CommentDto> comment) {
        this.comment = comment;
    }
}
