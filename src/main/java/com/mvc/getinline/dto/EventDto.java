package com.mvc.getinline.dto;

import com.mvc.getinline.constant.EventStatus;
import com.mvc.getinline.domain.Event;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.dto
 * File Name    : EventDTO
 * Description  : DTO(Data Transfer Object) 계층간 데이터 교환을 위해 사용하는 객체
 * <p> 도메인 Model 을 캡슐화하고, UI 화면에서 사용하는 데이터만 선택적으로 보낼 수 있음
 *     copy(Domain Model) + Persentation Logic
 * </p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-18     jeong       최초 생성
 */

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
    @NotBlank
    private Long id ;
    private Long placeId ;
    private PlaceDto placeDto;
    private String eventName ;
    private EventStatus eventStatus ;
    private LocalDateTime eventStartDatetime ;
    private LocalDateTime eventEndDatetime ;
    private Integer currentNumberOfPeople ;
    private Integer capacity ;
    private String memo ;
    private LocalDateTime createdAt ;
    private LocalDateTime modifiedAt ;

    /*
   * Entity 클래스와 DTO 클래스를 분리하는 이유
   . https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html
   */
    @Builder
    public EventDto(Long id,
                    Long placeId,
                    String eventName,
                    EventStatus eventStatus,
                    LocalDateTime eventStartDatetime,
                    LocalDateTime eventEndDatetime,
                    Integer currentNumberOfPeople,
                    Integer capacity,
                    String memo,
                    LocalDateTime createdAt,
                    LocalDateTime modifiedAt) {
        this.id = id;
        this.placeId = placeId;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity ;
        this.memo = memo ;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static EventDto of(
            Long id,
            Long placeId,
            String eventName,
            EventStatus eventStatus,
            LocalDateTime eventStartDatetime,
            LocalDateTime eventEndDatetime,
            Integer currentNumberOfPeople,
            Integer capacity,
            String memo,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ){
        return new EventDto(
                id,
                placeId,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime,
                currentNumberOfPeople,
                capacity,
                memo,
                createdAt,
                modifiedAt
        );
    }
    public static EventDto of(
                            Long placeId,
                            String eventName , // 오후_운동
                            EventStatus eventStatus, // opened
                            LocalDateTime eventStartDatetime,
                            LocalDateTime eventEndDatetime,
                            Integer currentNumberOfPeople,
                            Integer capacity,
                            String memo,  // "마스크_꼭_착용하세요"
                            LocalDateTime createdAt,
                            LocalDateTime modifiedAt)
    {
        return new EventDto(
                placeId,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime,
                currentNumberOfPeople,
                capacity,
                memo,
                createdAt,
                modifiedAt
        );
    }
    public EventDto(
                    Long placeId,
                    String eventName,
                    EventStatus eventStatus,
                    LocalDateTime eventStartDatetime,
                    LocalDateTime eventEndDatetime,
                    Integer currentNumberOfPeople,
                    Integer capacity,
                    String memo,
                    LocalDateTime createdAt,
                    LocalDateTime modifiedAt) {
        this.placeId = placeId;
        this.eventName = eventName;
        this.eventStatus = eventStatus;
        this.eventStartDatetime = eventStartDatetime;
        this.eventEndDatetime = eventEndDatetime;
        this.currentNumberOfPeople = currentNumberOfPeople;
        this.capacity = capacity ;
        this.memo = memo ;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    public static EventDto of(Event event) {
        return new EventDto(
                event.getId(),
                event.getPlaceId(),
                event.getEventName(),
                event.getEventStatus(),
                event.getEventStartDatetime(),
                event.getEventEndDatetime(),
                event.getCurrentNumberOfPeople(),
                event.getCapacity(),
                event.getMemo(),
                event.getCreatedAt(),
                event.getModifiedAt()
        );
    }


}
