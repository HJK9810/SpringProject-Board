package com.spring.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String[] AUTH_WHITELIST = { "/WEB_INF/spring/**", "/WEB_INF/views/**" };

	@Override
	public void configure(WebSecurity web) throws Exception {
		// 정적인 파일 요청에 대해 무시
		web.ignoring().antMatchers(AUTH_WHITELIST);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// /about 요청에 대해서는 로그인을 요구함
				.antMatchers("/eidt/**").authenticated()
				// /eidt 요청에 대해서는 ROLE_USER 역할을 가지고 있어야 함
				.antMatchers("/eidt").hasRole("USER")
				// 나머지 요청에 대해서는 로그인을 요구하지 않음
				.anyRequest().permitAll().and()
				// 로그인하는 경우에 대해 설정함
				.formLogin()
				// 로그인 페이지를 제공하는 URL을 설정함
				.loginPage("/login")
				// 로그인 성공 URL을 설정함
				.successForwardUrl("/")
				// 로그인 실패 URL을 설정함
				.failureForwardUrl("/index").permitAll();
	}

	@Bean
	public BCryptPasswordEncoder encodePassword() { // 회원가입 시 비밀번호 암호화에 사용할 Encoder 빈 등록
		return new BCryptPasswordEncoder();
	}
}
