package com.zhaoyang.restaurant.domain;

public class User {
	private Integer id;
	private String accountNum;
	private String pwd;
	private String name;
	
	public User() {}

	public User(Integer id, String userID, String pwd, String name) {
		super();
		this.id = id;
		this.accountNum = userID;
		this.pwd = pwd;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String userID) {
		this.accountNum = userID;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", accountNum=" + accountNum + ", pwd=" + pwd + ", name=" + name + "]";
	}
	
	
}
