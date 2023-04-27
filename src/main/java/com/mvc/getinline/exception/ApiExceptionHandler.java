package com.mvc.getinline.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;

/**
 * Package Name : com.mvc.getinline.exception
 * File Name    : ApiExceptionHandler
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */
public class ApiExceptionHandler {
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest webRequest) {
        return null;
    }

    public ResponseEntity<Object> general(GeneralException e, WebRequest webRequest) {
        return null;
    }

    public ResponseEntity<Object> handleExceptionInternal(Exception e, Object o, HttpHeaders headers, HttpStatus httpStatus, WebRequest webRequest) {
        return null;
    }

    public ResponseEntity<Object> exception(Exception e, WebRequest webRequest) {
        return null;
    }
}
