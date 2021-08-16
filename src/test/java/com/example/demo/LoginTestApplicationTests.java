package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class LoginTestApplicationTests {

	MockMvc mockmvc = 
	MockMvcBuilders.standaloneSetup(new LoginTestApplication()).build();
	
	
	
	@Test
	void contextLoads() {
	}

}
