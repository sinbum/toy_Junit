package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.dao.MemberDao;

public class Main {
		
	@Autowired
	
	public static void main(String[] args) {
		ApplicationContext context=
		new AnnotationConfigApplicationContext(com.example.demo.ConfigBean.class);
		MemberDao dao=(MemberDao)context.getBean(com.example.demo.dao.MemberDao.class);
		System.out.println(dao.read("user"));
	}

}
