package com.efoad.weather.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")

public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email", unique=true)
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="mobile")
	private String mobile;
	@Column(name="token")
	private String token;
	@OneToMany(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id")
	private List<Note> notes;

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public User(){
		super();
	}
	
	public User(String name, String email, String password, String mobile) {
		super();
//		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
