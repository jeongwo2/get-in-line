package com.mvc.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Package Name : com.mvc.getinline.controller
 * File Name    : AuthController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */
@Controller
public class AuthController {
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "auth/sign-up";
    }
}
