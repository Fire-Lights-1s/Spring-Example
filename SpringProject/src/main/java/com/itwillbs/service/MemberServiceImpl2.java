package com.itwillbs.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.dao.MemberDAOImpl2;
import com.itwillbs.domain.MemberDTO;

public class MemberServiceImpl2 implements MemberService{
	public boolean insertMember(MemberDTO memberDTO, HttpServletRequest request) {
		System.out.println("MemberServiceImpl2 insertMember()");
		MemberDAO memberDAO = new MemberDAOImpl2();
		try {
			memberDAO.insertMember(memberDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
