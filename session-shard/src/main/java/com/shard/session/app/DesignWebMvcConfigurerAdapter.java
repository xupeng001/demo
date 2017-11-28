package com.shard.session.app;

import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class DesignWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

	@Bean
	LoginInterceptor loginInterceptor(){
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
