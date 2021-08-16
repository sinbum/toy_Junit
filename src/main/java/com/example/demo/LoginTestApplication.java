package com.example.demo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.MemberDao;
import com.example.demo.service.MemberService;
import com.example.demo.vo.MemberVO;

@SpringBootApplication
//@RestController
@Controller
public class LoginTestApplication {

	//만약 DAO에서 사용을 한다면 여기서 두번 사용하면 안됨(datasource는싱글톤)
	//@Autowired
	//DataSource datasource;
	
	@Autowired
	//MemberDao member;
	MemberService service;
	
	//static JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(LoginTestApplication.class, args);
	try {
		
		//System.out.println(jdbcTemplate);
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}

	@RequestMapping("/")
	@ResponseBody
	public String root() {
		
		return "test";
	}
	
	@RequestMapping("/search")
	public String search() {
		return "/WEB-INF/view/search.jsp";
	}
	
	@RequestMapping("/read")
	public String read(Model model,String id) {
		//model.addAttribute("member",member.read("user"));
		model.addAttribute("member",service.read(id));
		return "/WEB-INF/view/read.jsp";
		//return "<html><head></head><body><h1>hello</h1></body></html>";
	}
	
	@RequestMapping("/getList")
	public String getList(Model model){
		model.addAttribute("list",service.getList());
		return "/WEB-INF/view/getList.jsp";
	}
	
	@RequestMapping("/insert")
	public String insert(){
		return "/WEB-INF/view/insert.jsp";
	}
	
	@RequestMapping("/insertProc")
	@ResponseBody
	public String insertProc(MemberVO member){
		if(service.insert(member)>0) {
			return "입력성공";
		}else{
			return "입력실패";
		}
		
	}
	
	@RequestMapping("/update")
	public String update(){
		return "/WEB-INF/view/update.jsp";
	}
	
	@RequestMapping("/updateProc")
	@ResponseBody
	public String updateProc(MemberVO member){
		if(service.update(member)>0) {
			return "수정성공";
		}else{
			return "수정실패";
		}
		
	}
	
	@RequestMapping("/delete")
	public String delete(){
		return "/WEB-INF/view/delete.jsp";
	}
	
	@RequestMapping("/deleteProc")
	@ResponseBody
	public String deleteProc(String id){
		if(service.delete(id)>0) {
			return "삭제성공";
		}else{
			return "삭제실패";
		}
		
	}
	
}
