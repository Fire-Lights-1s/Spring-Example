package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	public void connection() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/MysqlDB");
			this.conn = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}// connection
	
	public void dbClose(){
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean userCheck(MemberDTO member) throws SQLException {
		String sql = "SELECT id, pass FROM members WHERE id = ?";
		boolean result = false;
		connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		rs = pstmt.executeQuery();
		if(rs.next()) {
			if(member.getId().equals(rs.getString("id")) && member.getPass().equals(rs.getString("pass"))) {
				result = true;
			}
		}//if rs
		dbClose();
		return result;
	}
	public void insertMember(MemberDTO member) throws SQLException {
		String sql = "insert into members(id, pass, name, date) values(?,?,?,?);";
		connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPass());
		pstmt.setString(3, member.getName());
		pstmt.setTimestamp(4, member.getDate());
		pstmt.executeUpdate();
		
		dbClose();
	}
	public MemberDTO getMember(String id) throws SQLException {
		MemberDTO member = new MemberDTO();

		String sql = "SELECT * FROM members WHERE id = ?";
		connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			member.setId(rs.getString("id"));
			member.setPass(rs.getString("pass"));
			member.setName(rs.getString("name"));
			member.setDate(rs.getTimestamp("date"));
		}else {
			member = null;
		}//if rs 
		dbClose();
		return member;
	}//getMember
	public int getMemberCount() throws SQLException {
		int count=0;
		String sql = "select count(*) from members;";
		connection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			count = rs.getInt("count(*)");
		}
		dbClose();
		return count;
	}
	public ArrayList<MemberDTO> getMemberList(PageDTO pageDTO) throws SQLException{
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		int count=0;
		String sql = "select id, pass, name, date from members limit ?, ?;";
		connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pageDTO.getStartRow()-1);
		pstmt.setInt(2, pageDTO.getPageSize());
		rs = pstmt.executeQuery();
		
		while(rs.next() && rs != null){
			MemberDTO member = new MemberDTO();
			member.setId(rs.getString("id"));
			member.setPass(rs.getString("pass"));
			member.setName(rs.getString("name"));
			member.setDate(rs.getTimestamp("date"));
			memberList.add(member);
		}
		dbClose();
		return memberList;
	}
	public void updateMember(MemberDTO member) throws SQLException {
		String sql = "update members set name = ?  where id = ?;";
		connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getId());
		pstmt.executeUpdate();
		dbClose();
	}//setMember
	public void deleteMember(MemberDTO member) throws SQLException {
		String sql = "delete from members where id = ? && pass = ?";
		connection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPass());
		pstmt.executeUpdate();
		dbClose();
	}
}//MemberDAO