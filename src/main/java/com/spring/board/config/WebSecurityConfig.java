package com.spring.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");// Spring Security should completely ignore URLs starting with
													// /resources/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()// Form 로그인 인증 기능이 작동함
				.defaultSuccessUrl("/**", true).permitAll().and().logout();
//		http.authorizeRequests().antMatchers("/login").permitAll()
//				.antMatchers("/", "/api/one/**").hasRole("USER").anyRequest().authenticated(); // 일반사용자 접근 가능
//		// 인증 필요시 로그인 페이지와 로그인 성공시 리다이랙팅 경로 지정
//		http.formLogin().loginPage("/login").defaultSuccessUrl("/", true);
//		// 로그인이 수행될 uri 매핑 (post 요청이 기본)
//		http.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/", true);
//		// 인증된 사용자이지만 인가되지 않은 경로에 접근시 리다이랙팅 시킬 uri 지정
//		http.exceptionHandling().accessDeniedPage("/forbidden");
//		// logout
//		http.logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// basic user & guest setting
		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
		auth.inMemoryAuthentication().withUser("guest").password("{noop}guest").roles("GUEST");
	}
}
