package com.mvc.getinline.service;

import com.mvc.getinline.constant.ErrorCode;
import com.mvc.getinline.constant.EventStatus;
import com.mvc.getinline.dto.EventDto;
import com.mvc.getinline.exception.GeneralException;
import com.mvc.getinline.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Package Name : com.mvc.getinline.service
 * File Name    : EventService
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */

@RequiredArgsConstructor // 생성자 주입(final 이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성)
@Service
public class EventService {
    // @RequiredArgsConstructor 사용 시 @Autowired 생략
    private final EventRepository eventRepository;

    public List<EventDto> getEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) {
        try {
            return eventRepository.findEvents(
                    placeId,
                    eventName,
                    eventStatus,
                    eventStartDatetime,
                    eventEndDatetime
            );
        }
        catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public Optional<EventDto> getEvent(Long eventId) {
        try {
            return eventRepository.findEvent(eventId);
        }
        catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean createEvent(EventDto eventDTO) {
        try {
            return eventRepository.insertEvent(eventDTO);
        }
        catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean modifyEvent(Long eventId, EventDto dto) {
        try {
            return eventRepository.updateEvent(eventId, dto);
        }
        catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }

    public boolean removeEvent(Long eventId) {
        try {
            return eventRepository.deleteEvent(eventId);
        }
        catch (Exception e) {
            throw new GeneralException(ErrorCode.DATA_ACCESS_ERROR, e);
        }
    }
}
