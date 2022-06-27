package com.example.demo.member;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping
	public List<Member> getUsers() {
		return memberService.getMembers();

	}
	
}
