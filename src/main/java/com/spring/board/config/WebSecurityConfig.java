package com.spring.board.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

	private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().antMatchers("/resources/**");
//	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**"); // Spring Security should completely ignore URLs starting with /resources/
//	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		System.out.println("set url");
//		http.formLogin(withDefaults());
//		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).formLogin(withDefaults());
//		http.authorizeRequests(authorize -> authorize.anyRequest().authenticated()).formLogin(withDefaults())
//				.httpBasic(withDefaults());
		http.authorizeRequests().antMatchers("/**").hasRole("USER")
		.antMatchers("/favicon.ico").hasRole("ANONYMOUS")
		.and().formLogin();
		
		return http.build();
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
////		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
////				.formLogin(withDefaults()).httpBasic(withDefaults());
//
////		http.csrf().disable().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and()
////				.formLogin(withDefaults());
//		System.out.println("set url");
////		http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
////				.formLogin(formLogin -> formLogin.loginPage("/login").permitAll());
////		http.formLogin();
////		http.authorizeRequests().anyRequest().authenticated();
//		http.authorizeRequests().antMatchers("/**").hasRole("USER")
//			.antMatchers("/favicon.ico").hasRole("ANONYMOUS")
//			.and().formLogin();	
//		
////		http.authorizeRequests().antMatchers("/**").hasRole("USER").anyRequest().authenticated();
////		System.out.println("set user security");
////		http.formLogin().defaultSuccessUrl("/").permitAll();
////		System.out.println("allow login");
////		http.logout();
////		System.out.println("url load");
//	}

	@Bean
	public UserDetailsService userDetailsService() {
		System.out.println("set basic user");
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(User.withUsername("user").password("{noop}user").authorities("USER").build());
		return manager;
	}

//	@Autowired
//	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		System.out.println("set basic user");
//		// basic user & guest setting
//		auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER").and().withUser("guest")
//				.password("{noop}guest").roles("GUEST");
//	}

	@PostConstruct
	public void init() {
		log.info("WebSecurityConfig 설정 완료");
	}
}
