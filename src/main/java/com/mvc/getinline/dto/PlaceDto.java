package com.mvc.getinline.dto;

import com.mvc.getinline.constant.PlaceType;
import com.mvc.getinline.domain.Place;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.dto
 * File Name    : PlaceDto
 * Description  : DTO(Data Transfer Object) 계층간 데이터 교환을 위해 사용하는 객체
 * <p> 도메인 Model 을 캡슐화하고, UI 화면에서 사용하는 데이터만 선택적으로 보낼 수 있음
 *     copy(private Domain Model) + Persentation Logic
 *
 * </p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-18     jeong       최초 생성
 */
@Getter
@ToString
public class PlaceDto {

    private PlaceType placeType;
    private String placeName;
    private String address;
    private String phoneNumber;
    private Integer capacity;
    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public PlaceDto(
                    PlaceType placeType,
                    String placeName,
                    String address,
                    String phoneNumber,
                    Integer capacity,
                    String memo,
                    LocalDateTime createdAt,
                    LocalDateTime modifiedAt) {
        this.placeType = placeType;
        this.placeName = placeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.capacity = capacity;
        this.memo = memo;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static PlaceDto of(
            PlaceType placeType,  // common
            String placeName,
            String address,
            String phoneNumber,
            Integer capacity,
            String memo,
            LocalDateTime createdAt,
            LocalDateTime modifiedAt
    ) {
        return new PlaceDto(placeType, placeName, address, phoneNumber, capacity, memo, createdAt, modifiedAt);
    }


    public static PlaceDto of(Place place) {
        return new PlaceDto(
                place.getPlaceType(),
                place.getPlaceName(),
                place.getAddress(),
                place.getPhoneNumber(),
                place.getCapacity(),
                place.getMemo(),
                place.getCreatedAt(),
                place.getModifiedAt()
        );
    }

    // from : 입력 매개변수를 대상 클래스의 인스턴스로 변환합니다. 이 경우 입력에서 정보가 손실될 수 있습니다.
    public Place toEntity( ) {
        return Place.builder()
                .placeType(placeType)
                .placeName(placeName)
                .address(address)
                .phoneNumber(phoneNumber)
                .capacity(capacity)
                .memo(memo)
                .build();
    }
    public Place updateEntity(Place place) {
        if (placeType != null) { place.setPlaceType(placeType); }
        if (placeName != null) { place.setPlaceName(placeName); }
        if (address != null) { place.setAddress(address); }
        if (phoneNumber != null) { place.setPhoneNumber(phoneNumber); }
        if (capacity != null) { place.setCapacity(capacity); }
        if (memo != null) { place.setMemo(memo); }

        return place;
    }

}
