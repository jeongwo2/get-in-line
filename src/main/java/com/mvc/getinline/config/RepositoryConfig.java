package com.mvc.getinline.config;

import com.mvc.getinline.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package Name : com.mvc.getinline.config
 * File Name    : RepositoryConfig
 * Description  :
 * <p>
 * ===========================================================
 * Date        Author        NOTE
 * -----------------------------------------------------------
 * 2023-04-17     jeong       최초 생성
 */
@Configuration
public class RepositoryConfig {
    @Bean
    public EventRepository eventRepository() {
        return new EventRepository() {};
    }
}
