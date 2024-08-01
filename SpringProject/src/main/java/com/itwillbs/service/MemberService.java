package com.itwillbs.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.itwillbs.domain.MemberDTO;

public interface MemberService {
	public boolean insertMember(MemberDTO memberDTO, HttpServletRequest request);
	
}
