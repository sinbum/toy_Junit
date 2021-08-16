package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MemberVO;
@Repository
public class MemberDao {
	@Autowired
	DataSource datasource; //Connection을 획득가능
	
	public MemberDao() {}

	public MemberDao(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public MemberVO read(String id) {
		String sql="select * from member where id=?";

		try {
			PreparedStatement pstmt=datasource.getConnection().prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				MemberVO member
				=new MemberVO(rs.getString("id"),rs.getString("password"));
				rs.close();
				pstmt.close();
				System.out.println(member.toString());
				return member;
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int insert(MemberVO membervo) {
		String sql="insert into member values(?,?)";

		try {
			PreparedStatement pstmt=datasource.getConnection().prepareStatement(sql);
			pstmt.setString(1, membervo.getId());
			pstmt.setString(2, membervo.getPassword());
			int result=pstmt.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public int update(MemberVO membervo) {
		String sql="update member set password=? where id=?";

		try {
			PreparedStatement pstmt=datasource.getConnection().prepareStatement(sql);
			pstmt.setString(1, membervo.getPassword());
			pstmt.setString(2, membervo.getId());
			int result=pstmt.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(String id) {
		String sql="delete from member where id=?";

		try {
			PreparedStatement pstmt=datasource.getConnection().prepareStatement(sql);
			pstmt.setString(1, id);
			int result=pstmt.executeUpdate();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<MemberVO> getList() {
		List<MemberVO> list=new ArrayList<MemberVO>();
		String sql="select * from member";
		try {
			PreparedStatement pstmt=datasource.getConnection().prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO member
				=new MemberVO(rs.getString("id"),rs.getString("password"));
				list.add(member);
			}
			for(MemberVO m:list) {
				System.out.println(m);
			}
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
