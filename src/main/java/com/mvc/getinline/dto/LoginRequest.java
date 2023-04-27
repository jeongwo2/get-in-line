package com.mvc.getinline.dto;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode // equals, hashCode 자동 생성
public class  LoginRequest{
    private final String email;
    private final String password ;

    // final 을 사용하기 위해서는 생성자를 생성 해야 함
    @Builder
    public LoginRequest(String email, String password ) {
        this.email = email;
        this.password = password ;
    }

    public static LoginRequest of(
            String email,
            String password
    ) {
        return new LoginRequest(email, password);
    }
}
