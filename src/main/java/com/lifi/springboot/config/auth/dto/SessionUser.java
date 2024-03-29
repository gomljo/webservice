package com.lifi.springboot.config.auth.dto;

import com.lifi.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable{
    // 세션에 사용자 정보를 저장하기 위한 Dto 클래스
    // 인증된 사용자 정보만 필요하다.
    // 인증된 사용자 정보는 이름, 이메일, 사진이므로 이외의 속성은 필요없다.
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
