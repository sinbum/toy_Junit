package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVO;
@Service
public class MemberService {
@Autowired
MemberDao dao;

	public MemberVO read(String id) {
		return dao.read(id);
	}

	public List<MemberVO> getList() {
		return dao.getList();
	}

	public int insert(MemberVO member) {
		return dao.insert(member);
	}

	public int update(MemberVO member) {
		return dao.update(member);
	}

	public int delete(String id) {
		return dao.delete(id);
	}

}
