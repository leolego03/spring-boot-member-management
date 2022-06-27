package com.example.demo.member;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.time.LocalDate;

@Entity
@Table
public class Member {
	@Id
	@SequenceGenerator(
			name = "member_sequence",
			sequenceName = "member_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "member_sequence"
	)
	private Long id;
	private String name;
	private String email;
	private LocalDate dob;
	private Integer age;
	
	public Member() {
	}
	
	public Member(Long id,
				   String name,
				   String email,
				   LocalDate dob,
				   Integer age) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}
	
	public Member(String name,
			   	   String email,
			       LocalDate dob,
			       Integer age) {
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", email='" + email + '\'' +
	            ", dob=" + dob +
	            ", age=" + age +
	            '}';
	}
	
}
