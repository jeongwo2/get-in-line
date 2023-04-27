package com.mvc.getinline.controller;

import com.mvc.getinline.constant.EventStatus;
import com.mvc.getinline.constant.PlaceType;
import com.mvc.getinline.dto.EventDto;
import com.mvc.getinline.dto.PlaceDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Package Name : com.mvc.getinline.controller
 * File Name    : AdminController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */
@RequestMapping("/admin")
@Controller
@Log4j2   // log4j2
public class AdminController {
    @GetMapping("/places")
    public ModelAndView adminPlaces(
            PlaceType placeType,
            String placeName,
            String address
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("placeType", placeType);
        map.put("placeName", placeName);
        map.put("address", address);

        return new ModelAndView("admin/places", map);
    }

    @GetMapping("/places/{placeId}")
    public ModelAndView adminPlaceDetail(@PathVariable Long placeId) {
        Map<String, Object> map = new HashMap<>();
        map.put("place", PlaceDto.of(
                PlaceType.COMMON,
                "랄라배드민턴장",
                "서울시 강남구 강남대로 1234",
                "010-1234-5678",
                30,
                "신장개업",
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        return new ModelAndView("admin/place-detail", map);
    }

    @GetMapping("/events")
    public ModelAndView adminEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDatetime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDatetime
    ) {
        Map<String, Object> map = new HashMap<>();
        map.put("placeName", "place-" + placeId);
        map.put("eventName", eventName);
        map.put("eventStatus", eventStatus);
        map.put("eventStartDatetime", eventStartDatetime);
        map.put("eventEndDatetime", eventEndDatetime);

        return new ModelAndView("admin/events", map);
    }

    // Java ver 9.0 Map.of : 입력 매개변수의 유효성을 검사하고 변환하지 않는 인스턴스를 만듭니다.
    @GetMapping("/events/{eventId}")
    public ModelAndView adminEventDetail(@PathVariable Long eventId) {
        Map<String, Object> map = new HashMap<>();
        map.put("event", EventDto.of(
                1L,  // placeId
                "오후 운동",  // eventName
                EventStatus.OPENED, // eventStatus
                LocalDateTime.of(2021, 1, 1, 13, 0, 0), // eventStartDatetime
                LocalDateTime.of(2021, 1, 1, 16, 0, 0), // eventEndDatetime
                0,  // currentNumberOfPeople
                24, // capacity
                "마스크 꼭 착용하세요", // memo
                LocalDateTime.now(),
                LocalDateTime.now()
        ));

        return new ModelAndView("admin/event-detail", map);
    }
}
