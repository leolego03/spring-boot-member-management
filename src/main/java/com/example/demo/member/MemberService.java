package com.example.demo.member;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public List<Member> getMembers() {
		return memberRepository.findAll();
	}
}
