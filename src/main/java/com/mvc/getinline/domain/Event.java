package com.mvc.getinline.domain;

import com.mvc.getinline.constant.EventStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.domain
 * File Name    : Event
 * Description  : 이벤트
 * <p> @Data 대신  [ @Getter + @Setter + @ToString ]+ @EqualsAndHashCode + @RequiredArgsConstructor
 *    @NoArgsConstructor : 파라미터가 없는 생성자 생성
 *    @AllArgsConstructor : 모든 필드에 대한 생성자를 자동으로 생성
 *    @RequriedArgsConstructor : 모든 final 필드, @NonNull과 같이 제약조건이 설정되어있는 모든 필드
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */

@Getter
@Setter
@ToString
public class Event  {

    private Long id;

    private Long placeId;
    private String eventName;
    private EventStatus eventStatus;
    private LocalDateTime eventStartDatetime;
    private LocalDateTime eventEndDatetime;
    private Integer currentNumberOfPeople;
    private Integer capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
