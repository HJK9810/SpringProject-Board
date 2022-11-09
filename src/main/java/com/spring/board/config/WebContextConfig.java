
package com.spring.board.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebContextConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
		// set root servlet for use all servlets & filters
		servletAppContext.register(new Class[] { WebSecurityConfig.class, ServletContextConfig.class });
//		servletAppContext.register();
		// set dispacher servlet1
		DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
		// 부가 설정
		servlet.setLoadOnStartup(1); // set first start servlet
		servlet.addMapping("/"); // basic route

		// set root config file for connect db
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfig.class);

		// set srping container
		ContextLoaderListener listener = new ContextLoaderListener(rootContext);
		servletContext.addListener(listener);

		// for character encoding for utf-8
		FilterRegistration encoding = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
		encoding.setInitParameter("encoding", "UTF-8");
		encoding.setInitParameter("forceEncoding", "true");
		encoding.addMappingForUrlPatterns(null, true, "/*");
	}

}
