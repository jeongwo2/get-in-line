package com.mvc.getinline.constant;

import com.mvc.getinline.exception.GeneralException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Package Name : com.mvc.getinline.constant
 * File Name    : ErrorCode
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */

@Getter
// @RequiredArgsConstructor  // 필수적인 멤버 변수(final 변수)를 인자로 받는 생성자
@Log4j2
public enum ErrorCode {
    OK(0, HttpStatus.OK, "Ok"),

    // CLIENT_SIDE
    BAD_REQUEST(10000, HttpStatus.BAD_REQUEST, "Bad request"),
    SPRING_BAD_REQUEST(10001, HttpStatus.BAD_REQUEST, "Spring-detected bad request"),
    VALIDATION_ERROR(10002, HttpStatus.BAD_REQUEST, "Validation error"),
    NOT_FOUND(10003, HttpStatus.NOT_FOUND, "Requested resource is not found"),
    // SERVER_SIDE
    INTERNAL_ERROR(20000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal error"),
    SPRING_INTERNAL_ERROR(20001, HttpStatus.INTERNAL_SERVER_ERROR, "Spring-detected internal error"),
    DATA_ACCESS_ERROR(20002, HttpStatus.INTERNAL_SERVER_ERROR, "Data access error")
    ;

    private final Integer code;
    private ErrorCategory errorCategory; // 2023-04-19
    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(Integer code, HttpStatus httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;

        if ((String.valueOf(code)).startsWith("1"))
        {
            errorCategory = ErrorCategory.CLIENT_SIDE ;
        } else if ((String.valueOf(code)).startsWith("1"))
        {
            errorCategory = ErrorCategory.SERVER_SIDE ;
        }else{
            errorCategory = ErrorCategory.NORMAL ;
        }
        System.out.println("ErrorCode errorCategory =>" + errorCategory );
    }

    public String getMessage(Exception e) {
        log.info("Message=>" + e.getMessage() );
        return getMessage(e.getMessage());
    }

    public String getMessage(String message) {
        return Optional.ofNullable(message)
                .filter(Predicate.not(String::isBlank))
                .orElse(getMessage());
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", name(), this.getCode());
    }

    // 2023-04-19
    public static ErrorCode valueOf(HttpStatus httpStatus) {
        if (httpStatus == null) { throw new GeneralException("HttpStatus is null."); }

        return Arrays.stream(values())
                .filter(errorCode -> errorCode.getHttpStatus() == httpStatus)
                .findFirst()
                .orElseGet(() -> {
                    if (httpStatus.is4xxClientError()) { return ErrorCode.BAD_REQUEST; }
                    else if (httpStatus.is5xxServerError()) { return ErrorCode.INTERNAL_ERROR; }
                    else { return ErrorCode.OK; }
                });
    }

    // 2023-04-17
    public boolean isClientSideError() {
        // TODO
        System.out.println("Error code => " + this.code );
        return true;
    }

    public enum ErrorCategory {
        NORMAL, CLIENT_SIDE, SERVER_SIDE ;

        private ErrorCategory errorCategory;

        public boolean isClientSideError() {

            return this.errorCategory == ErrorCategory.CLIENT_SIDE;
        }

        public boolean isServerSideError() {

            return this.errorCategory == ErrorCategory.SERVER_SIDE;
        }

    }

}
