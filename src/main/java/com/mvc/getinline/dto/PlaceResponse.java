package com.mvc.getinline.dto;

import com.mvc.getinline.constant.PlaceType;
import lombok.*;

@Getter
@ToString
// @RequiredArgsConstructor // 선언된 모든 final 필드
@EqualsAndHashCode // equals, hashCode 자동 생성
public class PlaceResponse {
//    private final Long id;
    private final PlaceType placeType;
    private final String placeName;
    private final String address;
    private final String phoneNumber;
    private final Integer capacity;
    private final String memo;

    @Builder
    public PlaceResponse(
                         PlaceType placeType,
                         String placeName,
                         String address,
                         String phoneNumber,
                         Integer capacity,
                         String memo) {
       // this.id = id;
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static PlaceResponse of(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo
    ) {
        return new PlaceResponse( placeType, placeName, address, phoneNumber, capacity, memo );
    }

}
