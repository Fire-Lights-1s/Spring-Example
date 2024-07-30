package com.itwillbs.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.itwillbs.dao.MemberDAO;
import com.itwillbs.domain.MemberDTO;
import com.itwillbs.domain.PageDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	public boolean insertMember(HttpServletRequest request) {
		boolean result = false;
		System.out.println("MemberService inserMember()");
		MemberDTO member = new MemberDTO();
		boolean idCheck = false, passCheck = false, nameCheck = false;
		
		if(request.getParameter("id") != null && !request.getParameter("id").equals("")){
			member.setId(request.getParameter("id"));
			idCheck = true;
		}
		if(request.getParameter("pass") != null && !request.getParameter("pass").equals("")){
			member.setPass(request.getParameter("pass"));
			passCheck = true;
		}
		if(request.getParameter("name") != null && !request.getParameter("name").equals("")){
			member.setName(request.getParameter("name"));
			nameCheck = true;
		}
		member.setDate(new Timestamp(System.currentTimeMillis()));
		
		if(idCheck && passCheck && nameCheck){
			try {
				memberDAO.insertMember(member);
				result = true;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("유저 생성 실패");
				result = false;
			}
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("resultM", "필수 정보가 없음");
		}//if check
		return result;
	}// insertMember()
	
	public boolean userCheck(HttpServletRequest request) {
		boolean result = false;
		MemberDTO member = new MemberDTO();
		boolean idCheck = false, passCheck = false;
		// id와 pass의 유효성 확인
		if (request.getParameter("id") != null && !request.getParameter("id").equals("")) {
			member.setId(request.getParameter("id"));
			idCheck = true;
		}
		if (request.getParameter("pass") != null && !request.getParameter("pass").equals("")) {
			member.setPass(request.getParameter("pass"));
			passCheck = true;
		}
		try {
			if (idCheck && passCheck) {
				result = memberDAO.userCheck(member);
				if(result) {
					System.out.println("유저 확인 성공");
				}else {
					System.out.println("유저 확인 실패");
					HttpSession session = request.getSession();
					session.setAttribute("resultM", "아이디 또는 비밀번호가 다름");
				}
			}else {
				// 넘겨받은 id와 pass가 유효하지 않음
				HttpSession session = request.getSession();
				session.setAttribute("resultM", "필수 정보가 없음");
			} // if check id, pass
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}// userCheck()
	
	public MemberDTO getMember(String id) {
		MemberDTO member = null;
		try {
			member = memberDAO.getMember(id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("유저 정보 가져오기 실패");
		}
		return member;
	}// getMember()
	public void updateMember(HttpServletRequest request) {
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		member.setName(request.getParameter("name"));
		
		try {
				memberDAO.updateMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("유정 정보 업데이트 실패");
			HttpSession session = request.getSession();
			session.setAttribute("resultM", "업데이트 실패");
		}
	}// updateMember()
	
	public void deleteMember(HttpServletRequest request) {
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id"));
		member.setPass(request.getParameter("pass"));
		try {
			memberDAO.deleteMember(member);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("유저 삭제 실패");
		}
	}// deleteMember()
	public int getMemberCount() {
		int count=0;
		try {
			count = memberDAO.getMemberCount();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("유저수 조회 실패");
		}
		return count;
	}
	public ArrayList<MemberDTO> getMemberList(PageDTO pageDTO) {
		ArrayList<MemberDTO> memberList = null;
		try {
			memberList = memberDAO.getMemberList(pageDTO);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("유저 리스트 조회 실패");
		}
		
		return memberList;
	}//getMemberList()
}
