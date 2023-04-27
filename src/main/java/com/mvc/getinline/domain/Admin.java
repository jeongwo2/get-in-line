package com.mvc.getinline.domain;

import lombok.*;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Package Name : com.mvc.getinline.domain
 * File Name    : Admin
 * Description  : Entity Class (DB 테이블과 매핑) of the domain package
 * <p> DB의 테이블내에 존재하는 컬럼만을 속성(필드)
 * </p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */

@Getter
@Setter
@ToString
// @AllArgsConstructor  // 생성자를 만드는 Annotation
// @Entity     // JPA
public class Admin implements Serializable {
    // 멤버변수 = 속성(Attribute)

    // @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nickname;
    private String password;
    private String phoneNumber;
    private String memo;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}