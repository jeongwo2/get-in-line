package com.mvc.getinline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * Package Name : com.mvc.getinline
 * File Name    : GetInLineApplication
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */
@SpringBootApplication
@ConfigurationPropertiesScan
public class GetInLineApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(GetInLineApplication.class, args);
	}

}
