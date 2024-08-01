package com.itwillbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.itwillbs.domain.MemberDTO;

public class MemberDAOImpl implements MemberDAO{
	
	private SimpleJdbcTemplate jdbcTemplate;
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
	
	@Override
	public void insertMember(MemberDTO memberDTO) throws SQLException {
		
		System.out.println("MemberDAOImpl insertMember()");
		String sql = "insert into members(id, pass, name, date) values(?,?,?,?);"; 
		jdbcTemplate.update(sql, 
				memberDTO.getId(), 
				memberDTO.getPass(), 
				memberDTO.getName(),
				memberDTO.getDate());
		
	}

}
