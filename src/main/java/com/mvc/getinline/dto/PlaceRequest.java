package com.mvc.getinline.dto;

import com.mvc.getinline.constant.PlaceType;
import com.mvc.getinline.domain.Place;
import lombok.*;

@Getter
@ToString
// @RequiredArgsConstructor // 선언된 모든 final 필드 생성자
@EqualsAndHashCode // equals, hashCode 자동 생성
public class PlaceRequest {
    private final PlaceType placeType;
    private final String placeName;
    private final String address;
    private final String phoneNumber;
    private final Integer capacity;
    private final String memo;

    @Builder
    public PlaceRequest(PlaceType placeType,
                        String placeName,
                        String address,
                        String phoneNumber,
                        Integer capacity,
                        String memo) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
    }

    public static PlaceRequest of(
            PlaceType placeType,
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo
    ) {
        return new PlaceRequest(placeType, placeName, address, phoneNumber, capacity, memo);
    }

}
