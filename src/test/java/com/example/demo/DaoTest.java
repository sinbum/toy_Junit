package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVO;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= com.example.demo.ConfigBean.class,loader=AnnotationConfigContextLoader.class)
@SpringBootTest
class DaoTest {
	//@Mock
	//MemberDao dao;
	@Autowired
	MemberDao dao;
	//@Test
	void test() {
		MockitoAnnotations.openMocks(this);
		//when(dao.delete("user1")).thenReturn(1);
		//System.out.println(dao.delete("user"));
	}
	
	@Test
	void daotest() {
		//System.out.println(dao.insert(new MemberVO("daotest","1111")));
		assertNotNull(dao.read("user"));
		assertEquals(new MemberVO("user","1111").getId(), dao.read("user").getId());
		
	}

}
