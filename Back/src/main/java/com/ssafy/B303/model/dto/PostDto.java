package com.ssafy.B303.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data // getter, setter 자동으로 만들어줌
//@NoArgsConstructor // 디폴트 생성자 만들어줌
//@AllArgsConstructor // 모든 파라미터를 가진 생성자 만들어줌
//@JsonInclude(JsonInclude.Include.NON_NULL) // not_null인 경우만 포함한다. json을 만들 때 property가 null이면 만들지 말라
//@Getter @Setter
public class PostDto {
    private int id;
    private int user_id;
    private LocalDateTime created_time;
    private String title;
    private String contents;
    private Integer price;
    private String image;
    private int board_category;
    private Integer challenge_id;

}
