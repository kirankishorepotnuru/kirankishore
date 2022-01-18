package com.capg.BookStoreManagement.beans;

public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String userEmail;
	private String userAddress;
	private int userPhone;
	
	public User() {
		super();
	}
	
	public User(int userId,String userName,String userPwd,String userEmail,String userAddress,int userPhone) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
		this.userPhone = userPhone;
	}
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public int getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(int userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ",userEmail=" + userEmail
				+ ", userAddress=" + userAddress + ", userPhone=" + userPhone + "]";
	}
	
	
}
