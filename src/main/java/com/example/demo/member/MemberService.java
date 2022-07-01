package com.example.demo.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

	public void addNewMember(Member member) {
		Optional<Member> memberOptional = memberRepository
				.findMemberByEmail(member.getEmail());
		if (memberOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		memberRepository.save(member);
	}

	public void deleteMember(Long memberId) {
		boolean exists = memberRepository.existsById(memberId);
		if (!exists) {
			throw new IllegalStateException(
					"member with id " + memberId + " does not exists");
		}
		memberRepository.deleteById(memberId);
	}

	@Transactional
	public void updateMember(Long memberId,
							 String name,
							 String email) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new IllegalStateException(
						"member with id " + memberId + " does not exists"));
		
		if (name != null &&
				name.length() > 0 &&
				!Objects.equals(member.getName(), name)) {
			member.setName(name);
		}
		
		if (email != null &&
				email.length() > 0 &&
				!Objects.equals(member.getEmail(), email)) {
			Optional<Member> memberOptional = memberRepository
					.findMemberByEmail(email);
			if (memberOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			member.setEmail(email);
		}
	}
}
