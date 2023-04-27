package com.mvc.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Package Name : com.mvc.getinline.controller
 * File Name    : BaseController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */
@Controller
public class BaseController {
    @GetMapping("/")
    public String root() {
        return "index";
    }
}
