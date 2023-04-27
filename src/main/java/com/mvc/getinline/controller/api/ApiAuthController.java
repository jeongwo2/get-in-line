package com.mvc.getinline.controller.api;

import com.mvc.getinline.dto.AdminRequest;
import com.mvc.getinline.dto.ApiDataResponse;
import com.mvc.getinline.dto.LoginRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package Name : com.mvc.getinline.controller.api
 * File Name    : APIAuthController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-19     jeong       최초 생성
 */

@RequestMapping("/api")
@RestController
public class ApiAuthController {

    @PostMapping("/sign-up")
    public ApiDataResponse<String> signUp(@RequestBody AdminRequest adminRequest) {
        return ApiDataResponse.empty();
    }

    @PostMapping("/login")
    public ApiDataResponse<String> login(@RequestBody LoginRequest loginRequest) {
        return ApiDataResponse.empty();
    }
}
