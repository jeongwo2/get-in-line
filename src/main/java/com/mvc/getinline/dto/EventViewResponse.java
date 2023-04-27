package com.mvc.getinline.dto;

import com.mvc.getinline.constant.EventStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode // equals, hashCode 자동 생성
public class EventViewResponse
{
    private final Long id;
    // private final PlaceDto place;
    private final String placeName ;
    private final String eventName;
    private final EventStatus eventStatus;
    private final LocalDateTime eventStartDatetime;
    private final LocalDateTime eventEndDatetime;
    private final Integer currentNumberOfPeople;
    private final Integer capacity;
    private final String memo;

    @Builder
    public EventViewResponse(Long id,
                             String placeName,
                             String eventName,
                             EventStatus eventStatus,
                             LocalDateTime eventStartDatetime,
                             LocalDateTime eventEndDatetime,
                             Integer currentNumberOfPeople,
                             Integer capacity,
                             String memo) {
        this.id = id;
        this.placeName = placeName;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static EventViewResponse of(
            Long id,
            String placeName,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new EventViewResponse(
                id,
                placeName,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime,
                currentNumberOfPeople,
                capacity,
                memo
        );
    }

}
