package com.jimmy.core.dto;

/**
 * 类说明
 * 
 * @author Jimmy.Fang
 * @date 2018年3月16日 新建
 */
public class UserDto {
	private Integer userId;
	private String userName;
	private String password;
	private int age;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
