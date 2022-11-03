package com.spring.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public abstract class WebConfig implements WebMvcConfigurer {
	// 추상 class 사용 -> 불필요 상속X
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowCredentials(true).allowedOrigins("http://localhost:3000");
    }
	
    @Override
    public void configureContentNegotiation( ContentNegotiationConfigurer configurer )
    {
        configurer.defaultContentType( MediaType.APPLICATION_JSON );
    }
}
