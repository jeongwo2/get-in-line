package com.mvc.getinline.controller;

import com.mvc.getinline.domain.ContentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Package Name : com.mvc.getinline.controller
 * File Name    : HomeController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method=RequestMethod.GET)
    public ModelAndView goHome(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
//        List<String> resultList = new ArrayList<String>();
        // Thymeleaf에 파싱 하기
//        resultList.add("1. Thymeleaf prefix, suffix 정의");
//        resultList.add("2. 레이아웃 정의");
//        resultList.add("3. 공통 레이아웃 요소 정의");
//        resultList.add("4. content 작성");
//        resultList.add("5. Controller 수정");
//        resultList.add("6. Controller에서 값을 받아 Thymeleaf에 파싱 하기");
        // Model
        List<ContentModel> resultList = new ArrayList<ContentModel>();

        ContentModel cModel ;
        // new 생성과 set 대신에 builder 사용
        cModel = ContentModel.builder()
                .id(1)
                .name("Thymeleaf prefix, suffix 정의")
                .build();
        resultList.add(cModel);

        cModel = ContentModel.builder()
                .id(2)
                .name("레이아웃 정의")
                .build();
        resultList.add(cModel);

        cModel = ContentModel.builder()
                .id(3)
                .name("공통 레이아웃 요소 정의")
                .build();
        resultList.add(cModel);

        cModel = ContentModel.builder()
                .id(4)
                .name("content 작성")
                .build();
        resultList.add(cModel);

        cModel = ContentModel.builder()
                .id(5)
                .name("Controller 수정")
                .build();
        resultList.add(cModel);

        cModel = ContentModel.builder()
                .id(6)
                .name("Controller에서 값을 받아 Thymeleaf에 파싱 하기")
                .build();
        resultList.add(cModel);

        mav.addObject("resultList",resultList);
        mav.setViewName("content/home");

        return mav;
    }
}
