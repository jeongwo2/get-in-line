package com.mvc.getinline.dto;

import com.mvc.getinline.domain.Admin;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.dto
 * File Name    : AdminRequest
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-22     jeong       최초 생성
 */
@Getter
@ToString
@EqualsAndHashCode
public class AdminRequest {
    private final String email;
    private final String nickname;
    private final String password;
    private final String phoneNumber;
    private final String memo;

    // 순서와 상관 없이 만들 뿐만 아니라 입력하지 않은 값은 자동으로 Null 을 넣어 생성
    @Builder
    public AdminRequest(
            String email,
            String nickname,
            String password,
            String phoneNumber,
            String memo
    ) {
        this.email = email ;
        this.nickname = nickname ;
        this.password = password ;
        this.phoneNumber = phoneNumber ;
        this.memo = memo;
    }
    public static AdminRequest of(
            String email,
            String nickname,
            String password,
            String phoneNumber,
            String memo
    ) {
        return new AdminRequest(email, nickname, password, phoneNumber, memo);
    }
}
