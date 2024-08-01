package com.itwillbs.service;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl;
import com.itwillbs.dao.MemberDAOImpl2;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO memberDAO;
	
	
	@Inject
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	@Override
	public boolean insertMember(MemberDTO memberDTO, HttpServletRequest request) {
		System.out.println("MemberServiceImpl insertMember()");
		
		try {
			memberDAO.insertMember(memberDTO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	

}//클래스