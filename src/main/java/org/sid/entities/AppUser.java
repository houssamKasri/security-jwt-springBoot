package org.sid.entities;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// @Data @AllArgsConstructor @NoArgsConstructor
public class AppUser {
	@Id @GeneratedValue
	private Long id;
	@Column(unique = true)
	private String userName;
	private String passWord;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles = new ArrayList<>();
	
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(Long id, String userName, String passWord, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonIgnore
	public String getPassWord() {
		return passWord;
	}
	@JsonSetter
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	
	
}
