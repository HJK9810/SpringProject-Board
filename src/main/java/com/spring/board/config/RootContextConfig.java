package com.spring.board.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@MapperScan("com.spring.board.mapper")
@ComponentScans(value = { @ComponentScan("com.spring.board.service"), @ComponentScan("com.spring.board.service") })
public class RootContextConfig {
	
	@Bean // db connect
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://192.168.56.1:3306/forSpring?useSSL=FALSE&allowPublicKeyRetrieval=true&serverTimezone=Asia/Seoul");
		dataSource.setUsername("root");
		dataSource.setPassword("kopo12");
		
		return dataSource;
	}
	
	@Bean // mybatis SqlSessionFactoryBean - mybatis & mysql 연동
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSFactoryBean = new SqlSessionFactoryBean();
		sqlSFactoryBean.setDataSource(dataSource());
		return sqlSFactoryBean.getObject();
	}
	
	@Bean // connect mybatis
	public SqlSessionTemplate sqlSession(SqlSessionFactory sessionFactory) {
		SqlSessionTemplate sql = new SqlSessionTemplate(sessionFactory);
		sql.clearCache();
		return sql;
	}
}
