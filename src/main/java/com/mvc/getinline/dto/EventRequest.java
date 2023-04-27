package com.mvc.getinline.dto;

import com.mvc.getinline.constant.EventStatus;
import com.mvc.getinline.domain.Event;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode // equals, hashCode 자동 생성
public class EventRequest {
    @NotNull @Positive  // validation
    Long placeId ;
    @NotBlank
    private String eventName;
    @NotNull
    private EventStatus eventStatus;
    @NotNull
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime eventStartDatetime;
    @NotNull
    // @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime eventEndDatetime;
    @NotNull
    @PositiveOrZero
    private Integer currentNumberOfPeople;
    @NotNull
    @Positive
    private Integer capacity;
    private String memo;

    @Builder
    public EventRequest(Long placeId,
                        String eventName,
                        EventStatus eventStatus,
                        LocalDateTime eventStartDatetime,
                        LocalDateTime eventEndDatetime,
                        Integer currentNumberOfPeople,
                        Integer capacity,
                        String memo) {
        this.placeId = placeId ;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static EventRequest of(
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo
    ) {
        return new EventRequest(
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

    public EventDto toDTO() {
        return EventDto.of(
                null,
                this.placeId,
                this.eventName,
                this.eventStatus,
                this.eventStartDatetime,
                this.eventEndDatetime,
                this.currentNumberOfPeople,
                this.capacity,
                this.memo,
                null,
                null
        );
    }
    public EventDto toEntity() {
        return EventDto.builder()
                .placeId (placeId)
                .eventName(eventName)
                .eventStatus(eventStatus)
                .eventStartDatetime(eventStartDatetime)
                .eventEndDatetime(eventEndDatetime)
                .currentNumberOfPeople(currentNumberOfPeople)
                .capacity(capacity)
                .memo(memo)
                .build();
    }


}
