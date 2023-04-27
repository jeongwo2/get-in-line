package com.mvc.getinline.dto;

import com.mvc.getinline.constant.ErrorCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Package Name : com.mvc.getinline.dto
 * File Name    : ApiDataResponse
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-19     jeong       최초 생성
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class ApiDataResponse<T> extends ApiErrorResponse {

    private final T data;
    /*
     * Used by:
     *  String data = "Test data";
     *  ApiDataResponse<String> response = ApiDataResponse.of(data);
     */
    private ApiDataResponse(T data) {
        super(true, ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.data = data;
    }

    public static <T> ApiDataResponse<T> of(T data) {
        return new ApiDataResponse<>(data);
    }

    /*
     * Used by:
     *  ApiDataResponse.empty();
     */
    public static <T> ApiDataResponse<T> empty() {
        return new ApiDataResponse<>(null);
    }

}
