package com.mvc.getinline.dto;

import com.mvc.getinline.constant.EventStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode // equals, hashCode 자동 생성
public class EventResponse {
    private final Long id;
    private final Long  placeId;
    private final String eventName;
    private final EventStatus eventStatus;
    private final LocalDateTime eventStartDatetime;
    private final LocalDateTime eventEndDatetime;
    private final Integer currentNumberOfPeople;
    private final Integer capacity;
    private final String memo;

    // 생성자
    @Builder
    public EventResponse(Long id,
                         Long  placeId,
                         String eventName,
                         EventStatus eventStatus,
                         LocalDateTime eventStartDatetime,
                         LocalDateTime eventEndDatetime,
                         Integer currentNumberOfPeople,
                         Integer capacity,
                         String memo) {
        this.id = id;
        this.placeId = placeId;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static EventResponse of(
            Long id,
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new EventResponse(
                id,
                placeId,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime,
                currentNumberOfPeople,
                capacity,
                memo
        );
    }

    /* Used By:
     *   .stream().map(EventResponse::from).toList()
     */
    public static EventResponse from(EventDto eventDto) {
        if (eventDto == null) { return null; }
        return EventResponse.of(
                eventDto.getId(),
                eventDto.getPlaceId(),
                eventDto.getEventName(),
                eventDto.getEventStatus(),
                eventDto.getEventStartDatetime(),
                eventDto.getEventEndDatetime(),
                eventDto.getCurrentNumberOfPeople(),
                eventDto.getCapacity(),
                eventDto.getMemo()
        );
    }
}
