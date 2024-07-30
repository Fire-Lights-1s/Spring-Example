package com.itwillbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.service.MemberService;

@Controller
public class MemberController {
	@RequestMapping(value = "/member/insert", method = RequestMethod.GET)
	public String insert() {
		System.out.println("MemberController insert()");
		return "member/insert";
	}
	@RequestMapping(value = "/member/insertPro", method = RequestMethod.POST)
	public String insertPro(Model model) {
		System.out.println("MemberController insertPro()");
		
		MemberService memberService = new MemberService();
		
		if(memberService.insertMember(null)) {
			
		}
		return "redirect:member/login";
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("MemberController login()");
		return "member/login";
	}
	@RequestMapping(value = "/member/main", method = RequestMethod.GET)
	public String main() {
		System.out.println("MemberController main()");
		return "member/main";
	}
	@RequestMapping(value = "/member/info", method = RequestMethod.GET)
	public String info() {
		System.out.println("MemberController info()");
		return "member/info";
	}
	@RequestMapping(value = "/member/update", method = RequestMethod.GET)
	public String update() {
		System.out.println("MemberController update()");
		return "member/update";
	}
	@RequestMapping(value = "/member/delete", method = RequestMethod.GET)
	public String delete() {
		System.out.println("MemberController delete()");
		return "member/delete";
	}
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String list() {
		System.out.println("MemberController list()");
		return "member/list";
	}
}