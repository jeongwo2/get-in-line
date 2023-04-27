package com.mvc.getinline.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.domain
 * File Name    : AdminPlaceMap
 * Description  : 사용자와 장소의 매핑
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */

@Getter
@Setter
@ToString
public class AdminPlaceMap {

    private Long id;

    private Long adminId;
    private Long PlaceId;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
