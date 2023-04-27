package com.mvc.getinline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package Name : com.mvc.getinline.controller
 * File Name    : PlaceController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */
@RequestMapping("/places")
@Controller
public class PlaceController {
    @GetMapping
    public String places() {
        return "place/index";
    }

    @GetMapping("/{placeId}")
    public String placeDetail(@PathVariable Long placeId) {
        return "place/detail";
    }
}
