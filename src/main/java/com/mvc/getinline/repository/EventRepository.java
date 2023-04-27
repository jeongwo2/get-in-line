package com.mvc.getinline.repository;

import com.mvc.getinline.constant.EventStatus;
import com.mvc.getinline.dto.EventDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Package Name : com.mvc.getinline.repository
 * File Name    : EventRepository
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-21     jeong       최초 생성
 */
public interface EventRepository {
    // TODO: 인스턴스 생성 편의를 위해 임시로 default 사용. repository layer 구현이 완성되면 삭제할 것
    default  List<EventDto> findEvents(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime
    ) {
        return List.of();
    }
    default Optional<EventDto> findEvent(Long eventId) {
        return Optional.empty();
    }
    default  boolean insertEvent(EventDto eventDTO) { return false; }
    default  boolean updateEvent(Long eventId, EventDto dto) { return false; }
    default  boolean deleteEvent(Long eventId) { return false; }
}
