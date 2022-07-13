package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public List<Member> getMembers() {
		return memberService.getMembers();
	}
	
	@PostMapping
	public void registerNewMember(@RequestBody Member member) {
		memberService.addNewMember(member);
	}
	
	@DeleteMapping(path = "{memberId}")
	public void deleteMember(
			@PathVariable("memberId") Long memberId) {
		memberService.deleteMember(memberId);
	}
	
	@PutMapping(path = "{memberId}")
	public void updateMember(
			@PathVariable("memberId") Long memberId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		memberService.updateMember(memberId, name, email);
	}
}
