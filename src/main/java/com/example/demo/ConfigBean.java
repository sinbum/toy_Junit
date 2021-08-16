package com.example.demo;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.example.demo.dao.MemberDao;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
//@Component("com.example.demo.dao")
//@ComponentScan(basePackages = "com.example.demo.dao")
public class ConfigBean {
@Bean
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public HikariConfig hikariConfig() {
	return new HikariConfig();
}

@Bean
public DataSource dataSource() {
	DataSource dataSource=new HikariDataSource(hikariConfig());
	System.out.println(dataSource.toString());
	return dataSource;
}
/*
@Bean
public MemberDao memberDao() {
	return new MemberDao();
}
*/
}
