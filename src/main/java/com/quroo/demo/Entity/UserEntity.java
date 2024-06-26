package com.quroo.demo.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
    int userid;
	@Column(name="username")
	String name;
	@Column(name="useremail",unique = true)
	String email;
	@Column
	String bio;
	public UserEntity(int userid, String name, String email,String bio) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.bio=bio;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
}
