package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	@Test
	void contextLoads() throws Exception {
		mockmvc.perform(get("/test"))
		.andExpect(status().isOk())//url여부 확인//200이 나오면 정상.
		.andDo(print());
		
	}

}
