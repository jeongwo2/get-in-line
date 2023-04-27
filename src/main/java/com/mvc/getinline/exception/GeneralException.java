package com.mvc.getinline.exception;

import com.mvc.getinline.constant.ErrorCode;
import lombok.Getter;

/**
 * Package Name : com.mvc.getinline.exception
 * File Name    : GeneralException
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-22     jeong       최초 생성
 */
@Getter
public class GeneralException extends RuntimeException {
    private final ErrorCode errorCode;

    public GeneralException() {
        super();
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message) {
        super(message);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(Throwable cause) {
        super(cause);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }

    public GeneralException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public GeneralException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

    public GeneralException(ErrorCode errorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode.getMessage(), cause, enableSuppression, writableStackTrace);
        this.errorCode = ErrorCode.INTERNAL_ERROR;
    }
}
