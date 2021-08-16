package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class LoginTestApplicationTests {

	
	//url을 테스트하기 위한 가상 mvc객체 생성.
	MockMvc mockmvc = 
	MockMvcBuilders.standaloneSetup(new LoginTestApplication()).build();
	
	
	//일반적인 테스트 방법
	//@Test
	void contextLoads() throws Exception {
		mockmvc.perform(get("/"))
		.andExpect(status().isOk())//url여부 확인//200이 나오면 정상.
		.andDo(print());		
	}
	
	//리턴되는 내용을 확인하는 방법.
	//@Test
	void returnTest() throws Exception{
		mockmvc.perform(get("/test"))
		.andExpect(content().string("{\"name\": \"hong\"}"))
		.andDo(print());		
	}
	
	//페이지 확인하는 방법
	//@Test
	void pageTest() throws Exception{
		mockmvc.perform(get("/search"))
		.andDo(print())		
		.andExpect(view().name("/WEB-INF/view/search1.jsp"));
	}
	
	//@Test
	void attribute() throws Exception{
		mockmvc.perform(get("/attribute"))
		.andExpect(model().attributeExists("name"))
		.andExpect(model().attribute("name","hong1"))
		.andDo(print());		
	}
	
	//다른 객체를 이용해 객체를 얻는경우 new로 생성된 객체는 관계없지만
	// service와 같이 @Autowired로 연결된 객체는 문제가 되서 테스트가 되지를 않는다.(Mock은 가상객체)
	@Test
		void getListTest() throws Exception{
			mockmvc.perform(get("/getList"))
			.andExpect(model().attributeExists("list"))			
			.andDo(print());		
		}
	
	
	

}
