package com.ssafy.B303.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor // 모든 프라퍼티를 포함한 생성자를 생성
public class ResultDto { // insert나 update 시에는 쿼리 결과만을 리턴
    private Integer code;
    private String message;
}
