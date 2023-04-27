package com.mvc.getinline.domain;

import jdk.jshell.Snippet;
import lombok.*;

/**
 * Package Name : com.mvc.getinline.domain
 * File Name    : ContentModel
 * Description  : Thymeleaf
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-24     jeong       최초 생성
 */
@Getter
@Setter
@ToString
public class ContentModel {
    @NonNull
    private int id ;
    private String name;

    @Builder
    public ContentModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
