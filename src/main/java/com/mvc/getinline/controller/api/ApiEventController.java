package com.mvc.getinline.controller.api;

import com.mvc.getinline.constant.EventStatus;
import com.mvc.getinline.dto.ApiDataResponse;
import com.mvc.getinline.dto.EventRequest;
import com.mvc.getinline.dto.EventResponse;
import com.mvc.getinline.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Package Name : com.mvc.getinline.controller.api
 * File Name    : APIEventController
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-19     jeong       최초 생성
 */

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Validated  // 입력 파라미터의 유효성 검증은 컨트롤러에서 최대한 처리
public class ApiEventController {
    private final EventService eventService;

    @GetMapping("/events")
    public ApiDataResponse<List<EventResponse>> getEvents(
            @Positive Long placeId,
            @Size(min = 2) String eventName,
            EventStatus eventStatus,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventStartDatetime,
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime eventEndDatetime
    ) {
        List<EventResponse> eventResponses = eventService.getEvents(
                placeId,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime
        ).stream()
                .map(EventResponse::from)
                .collect(Collectors.toList());
        // JDK 16
        // .stream().map(EventResponse::from).toList();
        return ApiDataResponse.of(eventResponses);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/events")
    public ApiDataResponse<String> createEvent(@Valid @RequestBody EventRequest eventRequest) {
        boolean result = eventService.createEvent(eventRequest.toDTO());

        return ApiDataResponse.of(Boolean.toString(result));
    }

    @GetMapping("/events/{eventId}")
    public ApiDataResponse<EventResponse> getEvent(@Positive @PathVariable Long eventId) {
        EventResponse eventResponse = EventResponse.from(eventService.getEvent(eventId).orElse(null));

        return ApiDataResponse.of(eventResponse);
    }

    @PutMapping("/events/{eventId}")
    public ApiDataResponse<String> modifyEvent(
            @Positive @PathVariable Long eventId,
            @Valid @RequestBody EventRequest eventRequest
    ) {
        boolean result = eventService.modifyEvent(eventId, eventRequest.toDTO());
        return ApiDataResponse.of(Boolean.toString(result));
    }

    @DeleteMapping("/events/{eventId}")
    public ApiDataResponse<String> removeEvent(@Positive @PathVariable Long eventId) {
        boolean result = eventService.removeEvent(eventId);

        return ApiDataResponse.of(Boolean.toString(result));
    }
}
