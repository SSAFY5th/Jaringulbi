package com.ssafy.B303.model.aws;

import com.ssafy.B303.model.aws.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {
    private final AwsS3Service awsS3Service;
    // 자신의 버킷 주소로 입력하셔야합니다
    public static final String DOMAIN_NAME = "https://jaringulbi.s3.ap-northeast-2.amazonaws.com";
    public String createImage(MultipartFile image) throws IOException {
        String imgName = awsS3Service.uploadImage(image);
// 반환할 주소값
        String imgPath = "https://" + DOMAIN_NAME + "/" + imgName;
        return imgPath;
    }
}
