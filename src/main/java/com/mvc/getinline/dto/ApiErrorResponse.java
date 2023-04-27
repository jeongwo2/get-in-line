package com.mvc.getinline.dto;

import com.mvc.getinline.constant.ErrorCode;
import lombok.*;

/**
 * Package Name : com.mvc.getinline.dto
 * File Name    : ApiErrorResponse
 * Description  : VO(Value Object) 값 자체를 표현하는 객체
 * <p> 생성자
 *     getter + 비지니스 로직
 *     equals()와 hashCode() 메소드를 오버라이딩
 * </p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-19     jeong       최초 생성
 */
@Getter
@ToString
@EqualsAndHashCode // equals, hashCode 자동 생성
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class ApiErrorResponse {
    private final Boolean success;
    private final Integer errorCode;
    private final String message;

    public static ApiErrorResponse of(Boolean success, Integer errorCode, String message) {
        return new ApiErrorResponse(success, errorCode, message);
    }

    public static ApiErrorResponse of(Boolean success, ErrorCode errorCode) {
        return new ApiErrorResponse(success, errorCode.getCode(), errorCode.getMessage());
    }

    public static ApiErrorResponse of(Boolean success, ErrorCode errorCode, Exception e) {
        return new ApiErrorResponse(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static ApiErrorResponse of(Boolean success, ErrorCode errorCode, String message) {
        return new ApiErrorResponse(success, errorCode.getCode(), errorCode.getMessage(message));
    }

}
