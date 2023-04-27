package com.mvc.getinline.domain;

import com.mvc.getinline.constant.PlaceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.domain
 * File Name    : Place
 * Description  : 장소
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */

@Getter
@Setter
@ToString
public class Place {
    private Long id;

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public Place(PlaceType placeType, String placeName, String address, String phoneNumber, Integer capacity, String memo ) {

        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
    }

}
