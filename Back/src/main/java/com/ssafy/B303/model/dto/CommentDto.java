package com.ssafy.B303.model.dto;

import java.time.LocalDateTime;
import java.util.List;

//@Data // getter, setter 자동으로 만들어줌
//@NoArgsConstructor // 디폴트 생성자 만들어줌
//@AllArgsConstructor // 모든 파라미터를 가진 생성자 만들어줌
//@JsonInclude(JsonInclude.Include.NON_NULL) // not_null인 경우만 포함한다. json을 만들 때 property가 null이면 만들지 말라
public class CommentDto {
    private int id;
    private int post_id;
    private int user_id;
    private String nickname;
    private String contents;
    private LocalDateTime commented_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getCommented_time() {
        return commented_time;
    }

    public void setCommented_time(LocalDateTime commented_time) {
        this.commented_time = commented_time;
    }
}
